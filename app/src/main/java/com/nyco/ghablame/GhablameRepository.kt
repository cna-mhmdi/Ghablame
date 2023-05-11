package com.nyco.ghablame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nyco.ghablame.api.GhablameApi
import com.nyco.ghablame.model.Foods

class GhablameRepository(private val ghablameApi: GhablameApi) {

    private val foodsLiveData = MutableLiveData<List<Foods>>()

    val foods: LiveData<List<Foods>>
        get() = foodsLiveData

    suspend fun fetchFoods(){
            val foods = ghablameApi.getFoods()
            foodsLiveData.postValue(foods)
    }

}