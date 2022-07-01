package com.example.testapp

import com.example.testapp.data.remote.TodoApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    fun provideRetrofit() : Retrofit{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    single{
        provideRetrofit().create(TodoApi::class.java)
    }
}
