package com.fiz.starwarsinformer.features.peoples.data.repositories

import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.common.data.local.dao.PeopleDao
import com.fiz.starwarsinformer.common.data.local.entities.PeopleEntity
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.peoples.domain.models.People
import com.fiz.starwarsinformer.features.peoples.domain.repositories.PeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
        private val remoteDataSource: WorldApi,
        private val localDataSource: PeopleDao
) : PeopleRepository {

    override suspend fun getPeoples(fetchFromRemote: Boolean): Flow<Resource<List<People>>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getPeoples()
            emit(Resource.Success(
                    data = localData.map { it.toPeople() }
            ))

            val shouldJustLoadFromCache = localData.isNotEmpty() && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            var page = 1
            var remoteResults: MutableList<PeopleEntity>? = mutableListOf()

            do {
                val remoteData = try {
                    remoteDataSource.getPagePeoples(page)
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(R.string.network_error))
                    remoteResults = null
                    break
                }

                if (remoteResults != null) {
                    remoteResults += remoteData.results?.mapNotNull { it?.toPeopleEntity() }
                            ?: listOf()
                }

                page += 1

            } while (remoteData.next != null)

            remoteResults.let { data ->
                data?.let {
                    localDataSource.clearPeoples()
                    localDataSource.insertPeoples(
                            it
                    )
                }
                emit(Resource.Success(
                        data = localDataSource
                                .getPeoples()
                                .map { it.toPeople() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getPeople(name: String): Flow<Resource<People>> {
        return flow {
            emit(Resource.Loading(true))
            val localData = localDataSource.getPeople(name)
            emit(
                    Resource.Success(
                            data = localData.toPeople()
                    )
            )
            emit(Resource.Loading(false))
        }
    }
}