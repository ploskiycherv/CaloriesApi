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

    private var filter: String = ""

    private var disposableCalories: Disposable? = null

    private val caloriesItemLiveData = MutableLiveData<List<CaloriesItem>>()
    fun caloriesItemLiveData(): LiveData<List<CaloriesItem>> = caloriesItemLiveData

    private val errorLiveData = MutableLiveData<String>()
    fun errorLiveData(): LiveData<String> = errorLiveData

    fun changeFilter(filter: String) {
        this.filter = filter
        getListCalories()
    }

    fun getListCalories() {
        disposableCalories = repo.getCaloriesList(filter)
            .subscribeOn(Schedulers.io())
            .map {
                it.parsed?.map { parsed ->
                    parsed.food?.nutrients?.let { nutrients ->
                        CaloriesItem(
                            parsed.food.label.orEmpty(),
                            nutrients.eNERCKCAL ?: 0.0,
                            nutrients.pROCNT ?: 0.0,
                            nutrients.fAT ?: 0.0,
                            nutrients.cHOCDF ?: 0.0
                        )
                    }
                }.orEmpty()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.filterNotNull().let { notNullItems ->
                    caloriesItemLiveData.postValue(notNullItems)
                }
            }, {
                errorLiveData.postValue(it.message ?: "Something went wrong")
            })
    }

    override fun onCleared() {
        disposableCalories?.dispose()
    }
}