package com.example.caloriesapi.data.dto

import com.google.gson.annotations.SerializedName

data class NutrientsDto(
    @SerializedName("CHOCDF")
    val cHOCDF: Double?,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: Double?,
    @SerializedName("FAT")
    val fAT: Double?,
    @SerializedName("FIBTG")
    val fIBTG: Double?,
    @SerializedName("PROCNT")
    val pROCNT: Double?
)