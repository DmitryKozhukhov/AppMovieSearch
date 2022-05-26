package com.example.appmoviesearch

import com.example.appmoviesearch.model.Repository
import com.example.appmoviesearch.model.RepositoryImpl
import com.example.appmoviesearch.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Repository> { RepositoryImpl() }

    viewModel { MainViewModel(get()) }

}