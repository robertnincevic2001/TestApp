package com.example.testapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.data.model.databasemodels.GameEntity

@Database(
    entities = [
        GameEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDAO

    companion object {
        const val DATABASE_NAME = "gama_database.dbo"
        const val GAME_ENTITY = "game"
    }
}