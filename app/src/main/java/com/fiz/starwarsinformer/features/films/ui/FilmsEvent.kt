package com.fiz.starwarsinformer.features.films.ui

sealed class FilmsEvent {
    object Refresh : FilmsEvent()
}