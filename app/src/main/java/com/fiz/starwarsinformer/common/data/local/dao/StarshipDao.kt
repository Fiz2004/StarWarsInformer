package com.fiz.starwarsinformer.common.data.local.dao

import androidx.room.*
import com.fiz.starwarsinformer.common.data.local.entities.StarshipEntity

@Dao
interface StarshipDao {

    @Query("SELECT * FROM starships")
    suspend fun getStarships(): List<StarshipEntity>

    @Query("SELECT * FROM starships WHERE name==:name")
    suspend fun getStarship(name: String): StarshipEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarships(starships: List<StarshipEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarship(starship: StarshipEntity)

    @Query("DELETE FROM starships")
    suspend fun clearStarships()

    @Delete
    suspend fun clearStarship(starship: StarshipEntity)
}