package com.kodmse.appmoviesearch.model.repository

import com.kodmse.appmoviesearch.model.entities.Movie
import com.kodmse.appmoviesearch.model.entities.getAllMovies
import com.kodmse.appmoviesearch.model.entities.getTopMovies

class RepositoryImpl : Repository {

    override fun getMovieFromServer() = Movie()

    override fun getMovieFromLocalStorageAll() = getAllMovies()

    override fun getMovieFromLocalStorageTop250() = getTopMovies()
}