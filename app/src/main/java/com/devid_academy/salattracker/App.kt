package com.devid_academy.salattracker

import android.app.Application
import com.devid_academy.salattracker.di.databaseModule
import com.devid_academy.salattracker.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                databaseModule,
                viewModelsModule,
            )
        }
    }
}