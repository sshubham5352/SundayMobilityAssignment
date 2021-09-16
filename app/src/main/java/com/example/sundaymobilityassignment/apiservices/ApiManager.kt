package com.example.sundaymobilityassignment.apiservices

import com.example.sundaymobilityassignment.models.Countries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiManager(private val mApiResponse: ApiResponse) {

    fun getPlayers() {
        val call = ApiClient.services.getPlayers()

        call.enqueue(object : Callback<Countries> {
            override fun onResponse(call: Call<Countries>, response: Response<Countries>) {
                when {
                    response.body() != null -> mApiResponse.onCallResponse(response.body() as Countries)
                    response.code() == 401 -> mApiResponse.onCallFailure("Unauthorized Call")
                    response.code() == 404 -> mApiResponse.onCallFailure("Invalid Request")
                }

            }

            override fun onFailure(call: Call<Countries>, t: Throwable) {
                mApiResponse.onCallFailure(t.message ?: "Call Failure")
            }
        })
    }
}