package com.example.caloriesapi.domain.repo

import com.example.caloriesapi.data.dto.CaloriesResp
import io.reactivex.Single

interface CaloriesRepo {

    fun getCaloriesList(ingr: String):Single<CaloriesResp>

}