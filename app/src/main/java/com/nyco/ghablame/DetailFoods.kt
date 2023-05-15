package com.nyco.ghablame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailFoods : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD = "food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_ghablame_intro)

    }
}