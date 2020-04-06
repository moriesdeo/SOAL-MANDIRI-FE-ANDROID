package com.example.soalmandirifeandroid.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.soalmandirifeandroid.repositorymodel.RepositoryMainModel

class VmMovies(application: Application) : ViewModel() {
    private var repositoryMain = RepositoryMainModel(application)


}