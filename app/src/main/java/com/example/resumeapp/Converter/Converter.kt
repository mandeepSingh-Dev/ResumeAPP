package com.example.resumeapp.Converter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converter
{
    @TypeConverter
    fun fromBitmap(bitmap: Bitmap):ByteArray{
     val out = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG,100,out)
        return out.toByteArray()
    }
    @TypeConverter
    fun toBitmap(byteArray: ByteArray):Bitmap{
    return BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
    }
}