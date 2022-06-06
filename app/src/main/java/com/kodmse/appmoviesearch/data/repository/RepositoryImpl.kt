package com.kodmse.appmoviesearch.data.repository

import com.kodmse.appmoviesearch.domain.Movie
import com.kodmse.appmoviesearch.domain.getAllMovies
import com.kodmse.appmoviesearch.domain.getTopMovies

class RepositoryImpl : Repository {

    override fun getMovieFromServer() = Movie()

    override fun getMovieFromLocalStorageAll() = getAllMovies()

    override fun getMovieFromLocalStorageTop250() = getTopMovies()
}