package com.example.toshape

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BMIAdapter (
private val context: Context,
private val BMIs: List<BMIs>
) : RecyclerView.Adapter<BMIViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BMIViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_bmi, parent, false)
        return BMIViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: BMIViewHolder, position: Int) {
        val bmi = BMIs[position]
        holder.weight.text = bmi.weight
        holder.height.text = bmi.height
        holder.itemView.setOnClickListener {
            // Handle item click here, e.g., open BMIsActivity
            val intent = Intent(context, BMIsActivity::class.java)
            intent.putExtra("BMI_ID", position)
            context.startActivity(intent)
        }
    }
    override fun getItemCount() = BMIs.size
}