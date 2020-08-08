package com.example.caloriesapi.domain.entity

data class CaloriesItem(
    val label: String,
    val energy: Int,
    val protein: Int,
    val fat: Int,
    val carbohydrate: Int
)