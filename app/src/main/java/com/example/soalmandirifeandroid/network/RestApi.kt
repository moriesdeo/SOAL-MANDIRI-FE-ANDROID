package com.example.soalmandirifeandroid.network

import com.example.soalmandirifeandroid.BuildConfig
import com.example.soalmandirifeandroid.entity.ResponseDiscoveryMovies
import com.example.soalmandirifeandroid.entity.ResponseUpComingMovies
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestApi {
    companion object {

        fun create(): RestApi {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL + BuildConfig.TSDB_API_KEY)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApi::class.java)
        }
    }

    @Headers("X-Requested-With:XMLHttpRequest")
    @GET("discover/movie?")
    fun getDiscoveryMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<ResponseDiscoveryMovies>

    @Headers("X-Requested-With:XMLHttpRequest")
    @GET("movie/now_playing?")
    fun getListMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<ResponseUpComingMovies>
}