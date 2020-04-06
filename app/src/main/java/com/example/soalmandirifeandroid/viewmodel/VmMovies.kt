package com.example.soalmandirifeandroid.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soalmandirifeandroid.entity.ResponseUpComingMovies
import com.example.soalmandirifeandroid.repositorymodel.RepositoryMainModel

class VmMovies(application: Application) : ViewModel() {
    private var repositoryMain = RepositoryMainModel(application)

    var liveListMovies = MutableLiveData<ResponseUpComingMovies>()
    internal fun getListMovies() {
        repositoryMain.getListMovies(1, {
            liveListMovies.postValue(it)
        }, {

        })
    }
}