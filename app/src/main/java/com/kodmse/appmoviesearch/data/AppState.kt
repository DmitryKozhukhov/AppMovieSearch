package com.kodmse.appmoviesearch.data

import com.kodmse.appmoviesearch.domain.Movie

sealed class AppState {
    data class Success(val movieData: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
