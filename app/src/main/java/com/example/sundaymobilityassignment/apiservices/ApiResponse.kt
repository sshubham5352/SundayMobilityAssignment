package com.example.sundaymobilityassignment.apiservices

interface ApiResponse {
    fun onCallResponse(response: Any)
    fun onCallFailure(message: String)
}