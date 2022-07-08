package com.example.testapp.utils

import com.example.testapp.data.model.databasemodels.GameEntity
import com.example.testapp.data.model.retrofitmodels.GameDto

class Extensions

fun List<GameDto>.toGameEntityList() : List<GameEntity>{
    val listOfGames = ArrayList<GameEntity>()
    this.forEach{
        listOfGames.add(GameEntity(it.id, it.title, it.thumbnail, it.genre, it.gameUrl, it.visibility))
    }
    return listOfGames
}