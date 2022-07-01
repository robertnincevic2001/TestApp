package com.example.testapp.data.repository

import com.example.testapp.data.model.GameData
import com.example.testapp.data.model.Todo
import com.example.testapp.data.remote.TodoApi
import retrofit2.Call
import retrofit2.http.Query

class GameRepository(private val todoAPI : TodoApi) {

    fun getGame() = todoAPI.getTodos()

    fun getInfoAboutGame(gameID : Int) : Call <GameData>{
        return todoAPI.getGame(gameID)
    }

}