package com.fiz.starwarsinformer.features.starships.domain.repositories

import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.starships.domain.models.Starship
import kotlinx.coroutines.flow.Flow

interface StarshipRepository {

    suspend fun getStarships(fetchFromRemote: Boolean): Flow<Resource<List<Starship>>>

    suspend fun getStarship(name: String): Flow<Resource<Starship>>
}