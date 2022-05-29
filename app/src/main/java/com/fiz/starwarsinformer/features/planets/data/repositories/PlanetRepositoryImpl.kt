package com.fiz.starwarsinformer.features.planets.data.repositories

import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.common.data.local.dao.PlanetDao
import com.fiz.starwarsinformer.common.data.local.entities.PlanetEntity
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.planets.domain.models.Planet
import com.fiz.starwarsinformer.features.planets.domain.repositories.PlanetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(
        private val remoteDataSource: WorldApi,
        private val localDataSource: PlanetDao
) : PlanetRepository {

    override suspend fun getPlanets(fetchFromRemote: Boolean): Flow<Resource<List<Planet>>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getPlanets()
            emit(Resource.Success(
                    data = localData.map { it.toPlanet() }
            ))

            val shouldJustLoadFromCache = localData.isNotEmpty() && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            var page = 1
            var remoteResults: MutableList<PlanetEntity>? = mutableListOf()

            do {
                val remoteData = try {
                    remoteDataSource.getPagePlanets(page)
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(R.string.network_error))
                    remoteResults = null
                    break
                }

                if (remoteResults != null) {
                    remoteResults += remoteData.results?.mapNotNull { it?.toPlanetEntity() }
                            ?: listOf()
                }

                page += 1

            } while (remoteData.next != null)

            remoteResults.let { data ->
                data?.let {
                    localDataSource.clearPlanets()
                    localDataSource.insertPlanets(it)
                }
                emit(Resource.Success(
                        data = localDataSource
                                .getPlanets()
                                .map { it.toPlanet() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getPlanet(name: String): Flow<Resource<Planet>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getPlanet(name)
            emit(
                    Resource.Success(
                            data = localData.toPlanet()
                    )
            )
            emit(Resource.Loading(false))
        }
    }
}