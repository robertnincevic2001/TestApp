package com.example.testapp

import android.app.Application
import com.example.testapp.di.databaseModule
import com.example.testapp.di.parentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TestApp)
            modules(
                parentModule
            )
        }
    }
}