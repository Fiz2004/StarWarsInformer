package com.fiz.starwarsinformer.features.species.data.repositories

import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.common.data.local.dao.SpeciesDao
import com.fiz.starwarsinformer.common.data.local.entities.SpeciesEntity
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.species.domain.models.Species
import com.fiz.starwarsinformer.features.species.domain.repositories.SpeciesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpeciesRepositoryImpl @Inject constructor(
        private val remoteDataSource: WorldApi,
        private val localDataSource: SpeciesDao
) : SpeciesRepository {

    override suspend fun getAllSpecies(fetchFromRemote: Boolean): Flow<Resource<List<Species>>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getAllSpecies()
            emit(Resource.Success(
                    data = localData.map { it.toSpecies() }
            ))

            val shouldJustLoadFromCache = localData.isNotEmpty() && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            var page = 1
            var remoteResults: MutableList<SpeciesEntity>? = mutableListOf()

            do {
                val remoteData = try {
                    remoteDataSource.getPageSpecies(page)
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(R.string.network_error))
                    remoteResults = null
                    break
                }

                if (remoteResults != null) {
                    remoteResults += remoteData.results?.mapNotNull { it?.toSpeciesEntity() }
                            ?: listOf()
                }

                page += 1

            } while (remoteData.next != null)

            remoteResults.let { data ->
                data?.let {
                    localDataSource.clearAllSpecies()
                    localDataSource.insertAllSpecies(it)
                }
                emit(Resource.Success(
                        data = localDataSource
                                .getAllSpecies()
                                .map { it.toSpecies() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getSpecies(name: String): Flow<Resource<Species>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getSpecies(name)
            emit(
                    Resource.Success(
                            data = localData.toSpecies()
                    )
            )
            emit(Resource.Loading(false))
        }
    }
}