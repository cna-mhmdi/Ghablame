package com.nyco.ghablame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nyco.ghablame.model.Foods
import org.imaginativeworld.oopsnointernet.dialogs.signal.NoInternetDialogSignal

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

        noInternetDialog()

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
    private fun noInternetDialog() {
        NoInternetDialogSignal.Builder(
            this,
            lifecycle
        ).apply {
            dialogProperties.apply {

                cancelable = false
                noInternetConnectionTitle = "اینترنت متصل نیست !"
                noInternetConnectionMessage =
                    "برای استفاده از قابلمه نیاز به اینترنت دارید."
                showInternetOnButtons = true
                pleaseTurnOnText = "لطفا اینترنت خود را روشن کنید."
                wifiOnButtonText = "Wifi"
                mobileDataOnButtonText = "Mobile data"
                onAirplaneModeTitle = "حالت هوایپیما فعال است !"
                onAirplaneModeMessage = "برای استفاده از قابلمه نیاز به اینترنت دارید."
                pleaseTurnOffText = "لطفا دستگاه خود را از حالت هواپیما خارج کنید."
                airplaneModeOffButtonText = "حالت هواپیما"
                showAirplaneModeOffButtons = true
            }
        }.build()
    }
}