package com.oakil.fooddeliveryapplication.Data

import com.oakil.fooddeliveryapplication.Data.models.AuthResponse
import com.oakil.fooddeliveryapplication.Data.models.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodApi {
    @GET("/food")
    suspend fun getFood(): List<String>

    //request
    //response
    //endpoint

    @POST("/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): AuthResponse
}