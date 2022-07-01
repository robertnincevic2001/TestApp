package com.example.testapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testapp.data.model.Todo

@Database(entities = [Todo::class], version = 1 )

abstract class DataBase : RoomDatabase() {

    abstract  fun GameDAO() : GameDAO

    companion object{

        var instance : DataBase? = null

        //@Synchronized
        fun getInstance(context: Context) : DataBase {
            if(instance == null){
                synchronized(DataBase::class){
                    instance = Room.databaseBuilder(
                        context,
                        DataBase::class.java,
                        "DataBase"
                    ).build()
                }
            }
            return instance!!
        }
    }
}