package com.example.soalmandirifeandroid.network

import com.example.soalmandirifeandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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


}