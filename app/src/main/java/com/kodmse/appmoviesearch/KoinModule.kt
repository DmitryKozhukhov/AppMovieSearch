package com.kodmse.appmoviesearch

import com.kodmse.appmoviesearch.model.repository.Repository
import com.kodmse.appmoviesearch.model.repository.RepositoryImpl
import com.kodmse.appmoviesearch.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Repository> { RepositoryImpl() }

    viewModel { MainViewModel(get()) }

}