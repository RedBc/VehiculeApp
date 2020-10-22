package com.example.vehiculeapp.api

import com.example.vehiculeapp.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("vehicle/list")
    fun listVehicle(
        @Query("icon") icon: Int,
        @Query("lang") lang: String,
        @Query("forceStandard") forceStandard: Int,
        @Query("outputFormat") outputFormat: String,
        @Query("appToken") appToken: String
    ): Call<ApiResponse>
}