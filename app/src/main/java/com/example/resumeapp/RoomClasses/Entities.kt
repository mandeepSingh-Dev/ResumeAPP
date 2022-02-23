package com.example.resumeapp.RoomClasses

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Candidate_Details")
data class Entities(
                   @ColumnInfo(name = "name")
                    val name:String,
                   @ColumnInfo(name = "dob")
                    val dob:String,
                   @ColumnInfo(name = "gender")
                    val gender:String,
                   @ColumnInfo(name = "current_ctc")
                    val current_ctc:String,
                   @ColumnInfo(name = "expected_ctc")
                    val expected_ctc:String,
                   @ColumnInfo(name = "skills")
                    val skills: String,
                   @ColumnInfo(name = "bitmap")
                   val bitmap:Bitmap
                   ) {
                           @PrimaryKey(autoGenerate = true)
                           @ColumnInfo(name = "id")
                           val id:Int = 0
 //constructor(name:String,  dob:String,  gender:String,  current_ctc:String,  expected_ctc:String,skills:String,bitmap:Bitmap):this(0,name,dob,gender,current_ctc,expected_ctc,skills,bitmap)
}