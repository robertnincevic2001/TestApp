package com.example.testapp.data.repository

import com.example.testapp.data.local.AppDatabase
import com.example.testapp.data.local.GameDAO
import com.example.testapp.data.model.retrofitmodels.GameData
import com.example.testapp.data.model.retrofitmodels.Todo
import com.example.testapp.data.remote.TodoApi
import retrofit2.Call

class GameRepository(private val todoAPI : TodoApi, private val appDatabase: AppDatabase) {

    fun getGame() = todoAPI.getTodos()

    fun getInfoAboutGame(gameID : Int) : Call <GameData>{
        return todoAPI.getGame(gameID)
    }

    fun insertGamesInDatabase(games: List<Todo>) {
        appDatabase.gameDao().insertAll(games)
    }

}