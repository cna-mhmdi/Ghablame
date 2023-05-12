package com.nyco.ghablame

import android.app.Application
import com.nyco.ghablame.api.GhablameApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GhablameApplication : Application() {

    lateinit var ghablameRepository: GhablameRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ghablame.pythonanywhere.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val ghablameApi = retrofit.create(GhablameApi::class.java)

        ghablameRepository = GhablameRepository(ghablameApi)
    }
}