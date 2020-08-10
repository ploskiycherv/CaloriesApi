package com.example.caloriesapi

import android.app.Application
import com.example.caloriesapi.data.api.Api
import com.example.caloriesapi.data.repo.CaloriesRepoImpl
import com.example.caloriesapi.domain.repo.CaloriesRepo
import com.example.caloriesapi.presentation.list.CaloriesListModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        private const val BASE_URL = "https://api.edamam.com"
    }

    override fun onCreate() {
        super.onCreate()

        val module: Module = module {

            single<Retrofit> {
                Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            single<Api> {
                get<Retrofit>()
                    .create(Api::class.java)
            }

            single<CaloriesRepo> {
                CaloriesRepoImpl(get<Api>())
            }

            viewModel { CaloriesListModel(get<CaloriesRepo>()) }
        }
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    module
                )
            )
        }


    }

}
