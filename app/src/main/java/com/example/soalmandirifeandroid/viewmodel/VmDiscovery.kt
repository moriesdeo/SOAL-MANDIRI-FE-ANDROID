package com.example.soalmandirifeandroid.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soalmandirifeandroid.entity.BaseResponse
import com.example.soalmandirifeandroid.entity.ResultsItem
import com.example.soalmandirifeandroid.repositorymodel.RepositoryMainModel

class VmDiscovery(application: Application) : ViewModel() {
    private var repositoryMain = RepositoryMainModel(application)

    var liveDiscoveryMovies = MutableLiveData<BaseResponse<List<ResultsItem>>>()
    internal fun getDiscoveryMovies() {
        repositoryMain.getDiscoveryMovies({
            liveDiscoveryMovies.postValue(it)
        }, {

        })
    }
}