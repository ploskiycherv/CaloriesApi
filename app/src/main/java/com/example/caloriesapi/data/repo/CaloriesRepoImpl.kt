package com.example.caloriesapi.data.repo

import com.example.caloriesapi.data.api.Api
import com.example.caloriesapi.data.dto.CaloriesResp
import com.example.caloriesapi.domain.repo.CaloriesRepo
import io.reactivex.Single

class CaloriesRepoImpl(private val api: Api) : CaloriesRepo {

    override fun getCaloriesList(ingr: String): Single<CaloriesResp> = api
        .getCaloriesItem(ingr = ingr).map {
            if (it.isSuccessful && it.body() != null) {
                it.body()!!
            } else {
                error("Bad data")
            }

        }
}