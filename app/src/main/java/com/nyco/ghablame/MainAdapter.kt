package com.nyco.ghablame

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nyco.ghablame.api.Foods

class MainAdapter(private val clickListener: FoodClickListener):RecyclerView.Adapter<MainAdapter.MainViewHolder> {




    class MainViewHolder():ViewHolder(){

    }








    interface FoodClickListener{
        fun onCLick(foods: Foods)
    }
}