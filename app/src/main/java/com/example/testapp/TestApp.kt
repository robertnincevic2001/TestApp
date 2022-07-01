package com.example.testapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TestApp)
            modules(
                listOf(
                    retrofitModule,
                    appModule
                )
            )
        }
    }
}