package com.example.testapp.di

import android.app.Application
import androidx.room.Room
import com.example.testapp.data.local.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    fun provideAppDatabase(application: Application): AppDatabase {
        val builder = Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )

        return builder.build()
    }

    single { provideAppDatabase(get()) }
}