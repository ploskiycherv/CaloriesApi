package com.example.caloriesapi.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.caloriesapi.domain.entity.CaloriesItem

class CaloriesListDiffUtil: DiffUtil.ItemCallback<CaloriesItem>() {
    override fun areItemsTheSame(oldItem: CaloriesItem, newItem: CaloriesItem): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: CaloriesItem, newItem: CaloriesItem): Boolean =
        true

}