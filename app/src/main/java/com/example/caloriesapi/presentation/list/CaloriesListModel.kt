package com.example.caloriesapi.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caloriesapi.domain.entity.CaloriesItem
import com.example.caloriesapi.domain.repo.CaloriesRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CaloriesListModel(
    private val repo: CaloriesRepo
) : ViewModel() {

    private var disposableCalories: Disposable? = null

    private val caloriesItemLiveData = MutableLiveData<List<CaloriesItem>>()
    fun caloriesItemLiveData(): LiveData<List<CaloriesItem>> = caloriesItemLiveData

    private fun getListCalories(caloriesItemLiveData: MutableLiveData<List<CaloriesItem>>) {
        disposableCalories = repo.getCaloriesList()
            .subscribeOn(Schedulers.io())
            .map {
                it.parsed!!.map { parsed ->
                    parsed.food!!.nutrients.let { nutrients ->
                        CaloriesItem(
                            parsed.food.label!!,
                            nutrients?.eNERCKCAL!!,
                            nutrients.pROCNT!!,
                            nutrients.fAT!!,
                            nutrients.cHOCDF!!
                        )
                    }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                caloriesItemLiveData.value = it
            }, {

            })
    }

    fun getCalories() {
        getListCalories(caloriesItemLiveData)
    }

    override fun onCleared() {
        disposableCalories?.dispose()
    }
}