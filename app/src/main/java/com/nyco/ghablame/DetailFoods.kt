package com.nyco.ghablame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nyco.ghablame.utility.Utils

class DetailFoods : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD = "food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        Utils.noInternetDialog(this,lifecycle)

    }
}