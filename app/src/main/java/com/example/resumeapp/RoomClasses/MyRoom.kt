package com.example.resumeapp.RoomClasses

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Entities::class), version = 7, exportSchema = false)
abstract class MyRoom : RoomDatabase(){

    companion object {
        var instance: MyRoom? = null
        var databaseName = "ResumeDB"


        fun getInstance(context: Context): MyRoom {

            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, MyRoom::class.java, databaseName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }

    abstract fun getDao():Dao

}