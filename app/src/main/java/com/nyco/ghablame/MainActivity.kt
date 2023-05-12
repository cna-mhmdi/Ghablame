package com.nyco.ghablame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nyco.ghablame.model.Foods

class MainActivity : AppCompatActivity() {

    private val mainAdapter by lazy {
        MainAdapter(object : MainAdapter.ClickListener {
            override fun onFoodClicked(foods: Foods) {
                openFoodsDetail(foods)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.main_recyclerview)
        recyclerView.adapter = mainAdapter

        val ghablameRepository = (application as GhablameApplication).ghablameRepository
        val foodViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GhablameViewModel(ghablameRepository) as T
            }
        }).get(GhablameViewModel::class.java)

        foodViewModel.allFoods.observe(this) { allFood -> mainAdapter.addFoods(allFood) }

    }

    private fun openFoodsDetail(food: Foods) {
        val intent = Intent(this, DetailFoods::class.java).apply {
            putExtra(DetailFoods.EXTRA_FOOD, food)
        }
        startActivity(intent)
    }
}