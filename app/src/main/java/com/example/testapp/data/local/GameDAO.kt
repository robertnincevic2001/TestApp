package com.example.testapp.data.local

import androidx.room.*
import com.example.testapp.data.local.AppDatabase.Companion.GAME_ENTITY
import com.example.testapp.data.model.databasemodels.GameEntity

@Dao
interface GameDAO {

    @Query("SELECT * FROM $GAME_ENTITY")
    fun getAll(): List<GameEntity>

    @Insert
    fun insertAll(games : List<GameEntity>)

}