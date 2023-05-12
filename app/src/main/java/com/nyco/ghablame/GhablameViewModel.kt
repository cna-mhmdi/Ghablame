package com.nyco.ghablame

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyco.ghablame.model.Foods
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GhablameViewModel(private val ghablameRepository: GhablameRepository) : ViewModel() {


    init {
        fetchAllFoods()
    }

    val allFoods: LiveData<List<Foods>>
        get() = ghablameRepository.foods

    private fun fetchAllFoods() {
        viewModelScope.launch(Dispatchers.IO) {
            ghablameRepository.fetchFoods()
        }
    }
}