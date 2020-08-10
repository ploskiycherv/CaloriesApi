package com.example.caloriesapi.data.dto

import com.google.gson.annotations.SerializedName

data class FoodDto(
    @SerializedName("category")
    val category: String?,
    @SerializedName("categoryLabel")
    val categoryLabel: String?,
    @SerializedName("foodId")
    val foodId: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("nutrients")
    val nutrients: NutrientsDto?,
    @SerializedName("uri")
    val uri: String?
)