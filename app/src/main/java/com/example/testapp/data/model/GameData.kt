package com.example.testapp.data.model

import com.google.gson.annotations.SerializedName

data class GameData (
    val id: Int,
    val title: String,
    val thumbnail: String,
    @SerializedName("short_description")
    val shortDescription: String,
    val genre: String,
    val platform: String,
    val screenshots: List<Screenshot>
    )