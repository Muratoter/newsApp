package com.moter.newsapp

import android.app.Application
import com.moter.newsapp.di.appModule
import com.moter.newsapp.di.networkModule
import com.moter.newsapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Created by moter on 16.06.2019.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            val modules = listOf<Module>(appModule, networkModule, repositoryModule)
            androidContext(this@App)
            modules(modules)
        }
    }
}