package com.example.soalmandirifeandroid.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soalmandirifeandroid.entity.ResponseDiscoveryMovies
import com.example.soalmandirifeandroid.repositorymodel.RepositoryMainModel

class VmDiscovery(application: Application) : ViewModel() {
    private var repositoryMain = RepositoryMainModel(application)

    var liveDiscoveryMovies = MutableLiveData<ResponseDiscoveryMovies>()
    internal fun getDiscoveryMovies() {
        repositoryMain.getDiscoveryMovies({
            liveDiscoveryMovies.postValue(it)
        }, {

        })
    }
}