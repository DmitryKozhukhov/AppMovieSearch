package com.kodmse.appmoviesearch.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodmse.appmoviesearch.model.AppState
import com.kodmse.appmoviesearch.model.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData

    fun getMovieFromLocalSourceAll() = getDataFromLocalSource(true)

    fun getMovieFromLocalSourceTop250() = getDataFromLocalSource(false)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        localLiveData.value = AppState.Loading
        Thread {
            Thread.sleep(1000)
            localLiveData.postValue(
                if (isRussian) {
                    AppState.Success(repository.getMovieFromLocalStorageAll())
                } else {
                    AppState.Success(repository.getMovieFromLocalStorageTop250())
                }
            )
        }.start()
    }
}