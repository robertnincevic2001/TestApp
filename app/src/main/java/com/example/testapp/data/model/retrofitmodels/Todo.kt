package com.example.testapp.data.model.retrofitmodels

import com.google.gson.annotations.SerializedName

data class Todo (

    val id: Int,
    val title: String,
    val thumbnail: String,
    val genre: String,
    @SerializedName("game_url")
    val gameUrl: String,
    var visibility: Boolean = false
)