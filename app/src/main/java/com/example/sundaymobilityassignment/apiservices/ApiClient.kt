package com.example.sundaymobilityassignment.apiservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "http://test.oye.direct/"

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val services: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)
}