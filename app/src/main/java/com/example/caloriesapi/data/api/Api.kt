package com.example.caloriesapi.data.api

import com.example.caloriesapi.data.dto.CaloriesResp
import com.example.caloriesapi.domain.entity.CaloriesItem
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/api/food-database/v2/parser?ingr={ingr}&app_id=f575c04d&app_key=feef989c7f2249f0beea90f2358b09c7")
    fun getCaloriesItem(
        @Path("ingr") ingr: String
    ): Single<Response<CaloriesResp>>

}