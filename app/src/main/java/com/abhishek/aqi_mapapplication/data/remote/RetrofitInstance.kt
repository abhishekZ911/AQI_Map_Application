package com.abhishek.aqi_mapapplication.data.remote


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY

    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()


    val api: AqiApiService by lazy {

        Retrofit.Builder()
            .baseUrl("https://api.airveda.com/readapis/")
            .client(okHttpClient)
            .addConverterFactory( GsonConverterFactory.create())
            .build()
            .create(AqiApiService::class.java)


    }
}
