package com.kodmse.appmoviesearch.model.repository

import com.kodmse.appmoviesearch.model.entities.Movie

interface Repository {
    fun getMovieFromServer(): Movie
    fun getMovieFromLocalStorageAll(): List<Movie>
    fun getMovieFromLocalStorageTop250(): List<Movie>
}