package com.nyco.ghablame.api

import retrofit2.Call
import retrofit2.http.GET

interface GhablameApi {

    @GET("/ghablame/users/api")
    suspend fun getFoods():Call<List<Foods>>
}