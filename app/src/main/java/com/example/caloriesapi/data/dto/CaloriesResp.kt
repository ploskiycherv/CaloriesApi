package com.example.caloriesapi.data.dto

import com.google.gson.annotations.SerializedName

data class CaloriesResp(

    @SerializedName("parsed")
    val parsed: List<ParsedDto>?

)