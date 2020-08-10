package com.example.caloriesapi.data.dto

import com.google.gson.annotations.SerializedName

data class ParsedDto(
    @SerializedName("food")
    val food: FoodDto?
)