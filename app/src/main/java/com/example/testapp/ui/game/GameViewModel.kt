package com.example.testapp.ui.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.model.GameData
import com.example.testapp.data.repository.GameRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameViewModel(private val gameRepository: GameRepository) : ViewModel() {


    var dataSuccess = MutableLiveData<GameData>()
    val dataFailure = MutableLiveData<String>()

    fun getGameData(gameID : Int){
        gameRepository.getInfoAboutGame(gameID).enqueue(object : Callback<GameData>{
            override fun onResponse(call: Call<GameData>, response: Response<GameData>) {
                if(response.body() != null && response.isSuccessful){
                    dataSuccess.value = response.body()

                }
                else{
                    dataFailure.value = "Data not found"
                }
            }
            override fun onFailure(call: Call<GameData>, t: Throwable) {
                dataFailure.value = "Data not found"
            }

        })
    }




}