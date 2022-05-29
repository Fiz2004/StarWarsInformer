package com.fiz.starwarsinformer.features.peoples.domain.repositories

import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.peoples.domain.models.People
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {

    suspend fun getPeoples(fetchFromRemote: Boolean): Flow<Resource<List<People>>>

    suspend fun getPeople(name: String): Flow<Resource<People>>
}