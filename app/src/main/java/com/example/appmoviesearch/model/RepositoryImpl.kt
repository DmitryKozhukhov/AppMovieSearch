package com.example.appmoviesearch.model

class RepositoryImpl : Repository {

    override fun getMovieFromServer() = Movie()

    override fun getMovieFromLocalStorage() = Movie()
}