package com.example.resumeapp.RoomClasses

import kotlinx.coroutines.flow.Flow

class ResumeRepositry(val resumeDao:Dao)
{
    val resumesList: Flow<List<Entities>> = resumeDao.query()

    suspend fun insert(entities: Entities)
    {
        resumeDao.insert(entities)
    }
    suspend fun delete(entities: Entities)
    {
        resumeDao.delete(entities)
    }
    suspend fun update(entities: Entities)
    {
        resumeDao.update(entities)
    }
}