package com.fiz.starwarsinformer.features.planets.domain.repositories

import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.planets.domain.models.Planet
import kotlinx.coroutines.flow.Flow

interface PlanetRepository {

    suspend fun getPlanets(fetchFromRemote: Boolean): Flow<Resource<List<Planet>>>

    suspend fun getPlanet(name: String): Flow<Resource<Planet>>
}