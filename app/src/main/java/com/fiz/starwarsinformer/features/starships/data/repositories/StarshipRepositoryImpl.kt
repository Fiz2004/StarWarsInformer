package com.fiz.starwarsinformer.features.starships.data.repositories

import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.common.data.local.dao.StarshipDao
import com.fiz.starwarsinformer.common.data.local.entities.StarshipEntity
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.starships.domain.models.Starship
import com.fiz.starwarsinformer.features.starships.domain.repositories.StarshipRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StarshipRepositoryImpl @Inject constructor(
        private val remoteDataSource: WorldApi,
        private val localDataSource: StarshipDao
) : StarshipRepository {

    override suspend fun getStarships(fetchFromRemote: Boolean): Flow<Resource<List<Starship>>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getStarships()
            emit(Resource.Success(
                    data = localData.map { it.toStarship() }
            ))

            val shouldJustLoadFromCache = localData.isNotEmpty() && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            var page = 1
            var remoteResults: MutableList<StarshipEntity>? = mutableListOf()

            do {
                val remoteData = try {
                    remoteDataSource.getPageStarships(page)
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(R.string.network_error))
                    remoteResults = null
                    break
                }

                if (remoteResults != null) {
                    remoteResults += remoteData.results?.mapNotNull { it?.toStarshipEntity() }
                            ?: listOf()
                }

                page += 1

            } while (remoteData.next != null)

            remoteResults.let { data ->
                data?.let {
                    localDataSource.clearStarships()
                    localDataSource.insertStarships(
                            it
                    )
                }
                emit(Resource.Success(
                        data = localDataSource
                                .getStarships()
                                .map { it.toStarship() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getStarship(name: String): Flow<Resource<Starship>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getStarship(name)
            emit(
                    Resource.Success(
                            data = localData.toStarship()
                    )
            )
            emit(Resource.Loading(false))
        }
    }
}