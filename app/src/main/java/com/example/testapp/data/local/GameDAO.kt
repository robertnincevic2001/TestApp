package com.example.testapp.data.local

import androidx.room.*
import com.example.testapp.data.model.Todo

@Dao
interface GameDAO {

    @Insert
    fun insertAll( game: List<Todo>)

    @Delete
    fun delete( game: Todo)

    @Query("SELECT * FROM dataGame")
    fun getAll(): List<Todo>
}
