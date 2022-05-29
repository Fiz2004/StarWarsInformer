package com.fiz.starwarsinformer.common.data.local.dao

import androidx.room.*
import com.fiz.starwarsinformer.common.data.local.entities.FilmEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM films")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * FROM films WHERE title==:title")
    suspend fun getFilm(title: String): FilmEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilms(films: List<FilmEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: FilmEntity)

    @Query("DELETE FROM films")
    suspend fun clearFilms()

    @Delete
    suspend fun clearFilm(film: FilmEntity)
}