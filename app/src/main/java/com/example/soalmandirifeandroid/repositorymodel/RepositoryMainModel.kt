package com.example.soalmandirifeandroid.repositorymodel

import android.app.Application
import com.example.soalmandirifeandroid.BuildConfig
import com.example.soalmandirifeandroid.entity.ResponseDiscoveryMovies
import com.example.soalmandirifeandroid.entity.ResponseUpComingMovies
import com.example.soalmandirifeandroid.network.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryMainModel(application: Application) {
    private val service = RestApi.create()

    fun getDiscoveryMovies(
        onResult: (ResponseDiscoveryMovies?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        service.getDiscoveryMovies(BuildConfig.API_KEY, "en-US")
            .enqueue(object : Callback<ResponseDiscoveryMovies> {
                override fun onFailure(call: Call<ResponseDiscoveryMovies>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<ResponseDiscoveryMovies>,
                    response: Response<ResponseDiscoveryMovies>
                ) {
                    if (response.code() == 200) if (response.isSuccessful) onResult(response.body())
                }

            })
    }

    fun getListMovies(
        page: Int,
        onResult: (ResponseUpComingMovies?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        service.getListMovies(BuildConfig.API_KEY, "en-US", page)
            .enqueue(object : Callback<ResponseUpComingMovies> {
                override fun onFailure(call: Call<ResponseUpComingMovies>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<ResponseUpComingMovies>,
                    response: Response<ResponseUpComingMovies>
                ) {
                    if (response.code() == 200) if (response.isSuccessful) onResult(response.body())
                }

            })
    }
}