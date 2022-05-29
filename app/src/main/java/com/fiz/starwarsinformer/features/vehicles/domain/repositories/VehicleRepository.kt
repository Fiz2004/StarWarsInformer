package com.fiz.starwarsinformer.features.vehicles.domain.repositories

import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.vehicles.domain.models.Vehicle
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {

    suspend fun getVehicles(fetchFromRemote: Boolean): Flow<Resource<List<Vehicle>>>

    suspend fun getVehicle(name: String): Flow<Resource<Vehicle>>
}