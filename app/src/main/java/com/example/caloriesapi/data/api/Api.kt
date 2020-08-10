package com.example.caloriesapi.data.api

import com.example.caloriesapi.data.dto.CaloriesResp
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/api/food-database/v2/parser")
    fun getCaloriesItem(
        @Query("ingr") ingr: String,
        @Query("app_id") appId: String = "f575c04d",
        @Query("app_key") appKey: String = "feef989c7f2249f0beea90f2358b09c7"
    ): Single<Response<CaloriesResp>>

}