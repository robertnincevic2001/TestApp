package com.example.testapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "game_table")
data class Todo (

    @PrimaryKey
    val id: Int,
    val title: String,
    val thumbnail: String,
    val genre: String,
    @SerializedName("game_url")
    val gameUrl: String,
    var visibility: Boolean = false
)