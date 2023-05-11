package com.nyco.ghablame.api

import com.nyco.ghablame.model.Foods
import retrofit2.http.GET

interface GhablameApi {

    @GET("ghablame/users/api")
    suspend fun getFoods(): List<Foods>
}