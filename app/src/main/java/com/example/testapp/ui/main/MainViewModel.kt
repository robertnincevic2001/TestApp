package com.example.testapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.model.retrofitmodels.GameDto
import com.example.testapp.data.repository.GameRepository
import com.example.testapp.utils.toGameEntityList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val gameRepository: GameRepository) : ViewModel() {

    var dataSuccess = MutableLiveData<List<GameDto>>()
    var dataFailure = MutableLiveData<String>()

    fun getGames(){
        gameRepository.getGame().enqueue(object : Callback<List<GameDto>>{
            override fun onResponse(call: Call<List<GameDto>>, response: Response<List<GameDto>>) {
                if(response.isSuccessful && response.body() != null){
                    dataSuccess.value = response.body()

                    gameRepository.insertGamesInDatabase(response.body()!!.toGameEntityList())

                }
                else{
                    dataFailure.value = "Failed to load data"
                }
            }
            override fun onFailure(call: Call<List<GameDto>>, t: Throwable) {
                dataFailure.value = "Data is not recived"
            }
        })
    }
}