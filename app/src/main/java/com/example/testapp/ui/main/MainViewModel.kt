package com.example.testapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.model.Todo
import com.example.testapp.data.repository.GameRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val gameRepository: GameRepository) : ViewModel() {


    var dataSuccess = MutableLiveData<List<Todo>>()
    var dataFailure = MutableLiveData<String>()

    fun getGames(){
        gameRepository.getGame().enqueue(object : Callback<List<Todo>>{
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if(response.isSuccessful && response.body() != null){
                    dataSuccess.value = response.body()
                }
                else{
                    dataFailure.value = "Failed to load data"
                }
            }
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                dataFailure.value = "Data not recived"
            }
        })



    }

}