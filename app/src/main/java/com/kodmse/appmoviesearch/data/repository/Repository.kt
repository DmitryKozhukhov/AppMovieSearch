package com.kodmse.appmoviesearch.data.repository

import com.kodmse.appmoviesearch.domain.Movie

interface Repository {
    fun getMovieFromServer(): Movie
    fun getMovieFromLocalStorageAll(): List<Movie>
    fun getMovieFromLocalStorageTop250(): List<Movie>
}