package com.example.caloriesapi.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.caloriesapi.R
import com.example.caloriesapi.domain.entity.CaloriesItem
import kotlinx.android.synthetic.main.calories_list_item.view.*

class CaloriesListAdapter(
    diffCallback: DiffUtil.ItemCallback<CaloriesItem>
) : ListAdapter<CaloriesItem, CaloriesListViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaloriesListViewHolder =
        CaloriesListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.calories_list_item,
                parent,
                false))

    override fun onBindViewHolder(holder: CaloriesListViewHolder, position: Int) {
        with(holder.itemView) {
            getItem(position).let { item ->
                labelItemTextView.text = item.label
                energyItemTextView.text = item.energy.toString()
                proteinItemTextView.text = item.carbohydrate.toString()
                fatItemTextView.text = item.fat.toString()
                carbohydrateItemTextView.text = item.carbohydrate.toString()
            }
        }
    }
}