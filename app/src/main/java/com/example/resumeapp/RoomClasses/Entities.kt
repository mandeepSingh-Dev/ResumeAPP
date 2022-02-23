package com.example.resumeapp.RoomClasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Candidate_Details")
data class Entities(
                   @PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "id")
                   val id:Int,
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
                   ) {
 constructor(name:String,  dob:String,  gender:String,  current_ctc:String,  expected_ctc:String,skills:String):this(0,name,dob,gender,current_ctc,expected_ctc,skills)
}