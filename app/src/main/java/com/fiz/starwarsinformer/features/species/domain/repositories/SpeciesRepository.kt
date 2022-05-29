package com.fiz.starwarsinformer.features.species.domain.repositories

import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.species.domain.models.Species
import kotlinx.coroutines.flow.Flow

interface SpeciesRepository {

    suspend fun getAllSpecies(fetchFromRemote: Boolean): Flow<Resource<List<Species>>>

    suspend fun getSpecies(name: String): Flow<Resource<Species>>
}