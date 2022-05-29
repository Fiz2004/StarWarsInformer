package com.fiz.starwarsinformer.common.data.local.dao

import androidx.room.*
import com.fiz.starwarsinformer.common.data.local.entities.VehicleEntity

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicles")
    suspend fun getVehicles(): List<VehicleEntity>

    @Query("SELECT * FROM Vehicles WHERE name==:name")
    suspend fun getVehicle(name: String): VehicleEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicles(vehicles: List<VehicleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: VehicleEntity)

    @Query("DELETE FROM vehicles")
    suspend fun clearVehicles()

    @Delete
    suspend fun clearVehicle(vehicle: VehicleEntity)
}