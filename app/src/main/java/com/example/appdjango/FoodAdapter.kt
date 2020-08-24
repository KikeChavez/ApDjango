package com.example.appdjango

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(val foodList:List<FootResponseItem>):RecyclerView.Adapter<FoodAdapter.ViewHolder> () {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(food:FootResponseItem){
            val tvNameFood = itemView.findViewById<TextView>(R.id.tv_name)
            val tvCosto = itemView.findViewById<TextView>(R.id.tv_costo)
            val tvDetalles = itemView.findViewById<TextView>(R.id.tv_descrip)

            tvNameFood.text = food.nombre
            tvCosto.text = food.costo
            tvDetalles.text = food.descripcion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foodList[position])
    }
}