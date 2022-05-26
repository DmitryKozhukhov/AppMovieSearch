package com.example.appmoviesearch.model

interface Repository {
    fun getMovieFromServer(): Movie
    fun getMovieFromLocalStorage(): Movie
}