package com.fiz.starwarsinformer.common.data.local.dao

import androidx.room.*
import com.fiz.starwarsinformer.common.data.local.entities.PlanetEntity

@Dao
interface PlanetDao {

    @Query("SELECT * FROM planets")
    suspend fun getPlanets(): List<PlanetEntity>

    @Query("SELECT * FROM planets WHERE name==:name")
    suspend fun getPlanet(name: String): PlanetEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanets(planets: List<PlanetEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanet(planet: PlanetEntity)

    @Query("DELETE FROM planets")
    suspend fun clearPlanets()

    @Delete
    suspend fun clearPlanet(planet: PlanetEntity)
}