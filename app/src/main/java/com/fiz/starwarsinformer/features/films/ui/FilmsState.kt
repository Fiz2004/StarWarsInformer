package com.fiz.starwarsinformer.features.films.ui

import com.fiz.starwarsinformer.features.films.domain.models.Film

data class FilmsState(
    val films: List<Film> = emptyList(),
    val isLoading: Boolean = false,
    val error: Int? = null
)