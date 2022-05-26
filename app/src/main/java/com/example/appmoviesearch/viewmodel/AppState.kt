package com.example.appmoviesearch.viewmodel

import com.example.appmoviesearch.model.Movie

sealed class AppState{
    data class Success(val movieData: Movie) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
