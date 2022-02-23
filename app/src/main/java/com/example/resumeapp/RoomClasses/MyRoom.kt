package com.example.resumeapp.RoomClasses

import android.content.Context
import androidx.room.*
import com.example.resumeapp.Converter.Converter

@Database(entities = arrayOf(Entities::class), version = 5, exportSchema = false)
@TypeConverters(Converter::class)
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