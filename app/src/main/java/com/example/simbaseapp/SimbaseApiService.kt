package com.example.simbaseapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface SimbaseApiService {

    @GET("plans")
    fun getPlans(
        @Header("Authorization") apiKey : String
    ) : Call<List<DataPlan>>
}