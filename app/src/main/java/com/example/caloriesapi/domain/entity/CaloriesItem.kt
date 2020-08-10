package com.example.caloriesapi.domain.entity

data class CaloriesItem(
    val label: String,
    val energy: Double,
    val protein: Double,
    val fat: Double,
    val carbohydrate: Double
)