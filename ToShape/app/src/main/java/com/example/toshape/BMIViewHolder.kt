package com.example.toshape

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BMIViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val weight: TextView = itemView.findViewById(R.id.tv_bmi_weight)
    val height: TextView = itemView.findViewById(R.id.tv_bmi_height)
}