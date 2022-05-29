package com.fiz.starwarsinformer.features.films.domain.repositories

import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.films.domain.models.Film

interface FilmRepository {

    suspend fun getFilms(fetchFromRemote: Boolean): Resource<List<Film>>

    suspend fun getFilm(title: String): Resource<Film>
}