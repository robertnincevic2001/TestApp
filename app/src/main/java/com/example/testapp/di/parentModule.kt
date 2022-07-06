package com.example.testapp.di

import com.example.testapp.appModule
import com.example.testapp.retrofitModule
import org.koin.dsl.module

val parentModule = module {
    includes(databaseModule, retrofitModule, appModule)
}