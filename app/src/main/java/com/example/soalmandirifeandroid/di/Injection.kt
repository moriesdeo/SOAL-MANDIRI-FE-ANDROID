package com.example.soalmandirifeandroid.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.soalmandirifeandroid.viewmodel.ViewModelFactory

object Injection {
    fun provideViewModelFactory(application: Application): ViewModelProvider.Factory {
        return ViewModelFactory(application)
    }
}