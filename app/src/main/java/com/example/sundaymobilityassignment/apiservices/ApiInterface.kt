package com.example.sundaymobilityassignment.apiservices

import com.example.sundaymobilityassignment.models.Countries
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("players.json")
    fun getPlayers(): Call<Countries>
}