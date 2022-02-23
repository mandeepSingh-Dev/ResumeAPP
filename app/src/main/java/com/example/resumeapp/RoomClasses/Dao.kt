package com.example.resumeapp.RoomClasses

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao
{
    @Insert
    suspend fun insert(entities: Entities)

    @Update
    suspend fun update(entities: Entities)

    @Delete
    suspend fun delete(entities: Entities)

    @Query("SELECT * FROM CANDIDATE_DETAILS")
    fun query() : Flow<List<Entities>>
}