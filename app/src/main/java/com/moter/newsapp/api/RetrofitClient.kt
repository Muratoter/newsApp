package com.moter.newsapp.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by moter on 16.06.2019.
 */
object RetrofitClient {
    private var ourInstance: Retrofit? = null

    val instance: Retrofit
        get() {
            if (ourInstance == null) {
                ourInstance = Retrofit.Builder()
                    .baseUrl(Config.API_ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
            }
            return ourInstance!!
        }
}