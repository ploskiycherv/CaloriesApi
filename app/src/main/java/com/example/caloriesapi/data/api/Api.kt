package com.example.caloriesapi.data.api

import com.example.caloriesapi.data.dto.CaloriesResp
import com.example.caloriesapi.domain.entity.CaloriesItem
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/api/food-database/v2/parser?ingr=red%20apple&app_id=f575c04d&app_key=feef989c7f2249f0beea90f2358b09c7")
    fun getCaloriesItem(): Single<Response<CaloriesResp>>

}