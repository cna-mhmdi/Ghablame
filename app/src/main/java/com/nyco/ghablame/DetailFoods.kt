package com.nyco.ghablame

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class DetailFoods: AppCompatActivity() {

    companion object{
        const val EXTRA_FOOD = "food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

    }
}