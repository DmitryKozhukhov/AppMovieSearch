package com.kodmse.appmoviesearch.model

import com.kodmse.appmoviesearch.model.entities.Movie

sealed class AppState{
    data class Success(val movieData: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
