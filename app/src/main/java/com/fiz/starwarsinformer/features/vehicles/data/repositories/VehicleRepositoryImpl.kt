package com.fiz.starwarsinformer.features.vehicles.data.repositories

import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.common.data.local.dao.VehicleDao
import com.fiz.starwarsinformer.common.data.local.entities.VehicleEntity
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.vehicles.domain.models.Vehicle
import com.fiz.starwarsinformer.features.vehicles.domain.repositories.VehicleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(
        private val remoteDataSource: WorldApi,
        private val localDataSource: VehicleDao
) : VehicleRepository {

    override suspend fun getVehicles(fetchFromRemote: Boolean): Flow<Resource<List<Vehicle>>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getVehicles()
            emit(Resource.Success(
                    data = localData.map { it.toVehicle() }
            ))

            val shouldJustLoadFromCache = localData.isNotEmpty() && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            var page = 1
            var remoteResults: MutableList<VehicleEntity>? = mutableListOf()

            do {
                val remoteData = try {
                    remoteDataSource.getPageVehicles(page)
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(R.string.network_error))
                    remoteResults = null
                    break
                }

                if (remoteResults != null) {
                    remoteResults += remoteData.results?.mapNotNull { it?.toVehicleEntity() }
                            ?: listOf()
                }

                page += 1

            } while (remoteData.next != null)

            remoteResults.let { data ->
                data?.let {
                    localDataSource.clearVehicles()
                    localDataSource.insertVehicles(
                            it
                    )
                }
                emit(Resource.Success(
                        data = localDataSource
                                .getVehicles()
                                .map { it.toVehicle() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getVehicle(name: String): Flow<Resource<Vehicle>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getVehicle(name)
            emit(
                    Resource.Success(
                            data = localData.toVehicle()
                    )
            )
            emit(Resource.Loading(false))
        }
    }
}