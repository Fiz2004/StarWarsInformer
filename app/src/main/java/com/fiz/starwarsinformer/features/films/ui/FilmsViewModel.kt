package com.fiz.starwarsinformer.features.films.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.films.domain.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val filmRepository: FilmRepository
) : ViewModel() {
    var state by mutableStateOf(FilmsState())
        private set

    init {
        getFilms(true)
    }

    fun onEvent(event: FilmsEvent) {
        when (event) {
            is FilmsEvent.Refresh -> {
                getFilms(fetchFromRemote = true)
            }
        }
    }

    fun getFilms(fetchFromRemote: Boolean) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            when (val filmsResult = filmRepository.getFilms(fetchFromRemote)) {
                is Resource.Success -> {
                    state = state.copy(
                        films = filmsResult.data ?: listOf(),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        films = listOf(),
                        error = filmsResult.message,
                        isLoading = false
                    )
                }
                else -> Unit
            }
        }
    }
}