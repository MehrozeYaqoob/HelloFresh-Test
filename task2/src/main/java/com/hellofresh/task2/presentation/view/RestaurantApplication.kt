package com.hellofresh.task2.presentation.view

import android.app.Application
import com.hellofresh.task2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RestaurantApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RestaurantApplication)
            modules(listOf(appModule))
        }
    }
}
