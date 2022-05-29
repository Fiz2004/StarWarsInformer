package com.fiz.starwarsinformer.common.data.local.dao

import androidx.room.*
import com.fiz.starwarsinformer.common.data.local.entities.SpeciesEntity

@Dao
interface SpeciesDao {

    @Query("SELECT * FROM species")
    suspend fun getAllSpecies(): List<SpeciesEntity>

    @Query("SELECT * FROM species WHERE name==:name")
    suspend fun getSpecies(name: String): SpeciesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSpecies(species: List<SpeciesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpecies(species: SpeciesEntity)

    @Query("DELETE FROM species")
    suspend fun clearAllSpecies()

    @Delete
    suspend fun clearSpecies(species: SpeciesEntity)
}