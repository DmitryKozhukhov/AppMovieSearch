package com.kodmse.appmoviesearch

import com.kodmse.appmoviesearch.data.repository.Repository
import com.kodmse.appmoviesearch.data.repository.RepositoryImpl
import com.kodmse.appmoviesearch.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Repository> { RepositoryImpl() }

    viewModel { MainViewModel(get()) }

}