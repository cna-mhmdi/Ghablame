package com.nyco.ghablame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyco.ghablame.model.Foods


class MainAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<MainAdapter.FoodViewHolder>() {

    private val foods = mutableListOf<Foods>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_card_view, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
        holder.itemView.setOnClickListener { clickListener.onFoodClicked(food) }
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun addFoods(foodList: List<Foods>) {
        foods.addAll(foodList)
        notifyItemRangeInserted(0, foodList.size)
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodsTitle: TextView by lazy {
            itemView.findViewById(R.id.main_card_title)
        }

        private val foodsImage: ImageView by lazy {
            itemView.findViewById(R.id.main_card_image)
        }

        fun bind(food: Foods) {
            //image view will add later
            foodsTitle.text = food.username
        }
    }

    interface ClickListener {
        fun onFoodClicked(foods: Foods)
    }
}