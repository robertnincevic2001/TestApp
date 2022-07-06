package com.example.testapp.data.model.databasemodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testapp.data.local.AppDatabase
import com.google.gson.annotations.SerializedName


@Entity(tableName = AppDatabase.GAME_ENTITY)
data class GameEntity (

        @PrimaryKey
        val id: Int,
        val title: String,
        val thumbnail: String,
        val genre: String,
        @SerializedName("game_url")
        val gameUrl: String,
        var visibility: Boolean = false


)


