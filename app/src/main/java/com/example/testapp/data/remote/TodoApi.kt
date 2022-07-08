package com.example.testapp.data.remote

import com.example.testapp.data.model.retrofitmodels.GameData
import com.example.testapp.data.model.retrofitmodels.GameDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {

    @GET("/api/games")
    fun getTodos(): Call <List<GameDto>>

    @GET("/api/game")
    fun getGame(@Query("id")id:Int): Call <GameData>
}