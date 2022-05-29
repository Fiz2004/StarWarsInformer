package com.fiz.starwarsinformer.common.data.local.dao

import androidx.room.*
import com.fiz.starwarsinformer.common.data.local.entities.PeopleEntity

@Dao
interface PeopleDao {

    @Query("SELECT * FROM peoples")
    suspend fun getPeoples(): List<PeopleEntity>

    @Query("SELECT * FROM peoples WHERE name==:name")
    suspend fun getPeople(name: String): PeopleEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeoples(peoples: List<PeopleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeople(people: PeopleEntity)

    @Query("DELETE FROM peoples")
    suspend fun clearPeoples()

    @Delete
    suspend fun clearPeople(people: PeopleEntity)
}