package com.example.resumeapp.RoomClasses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel(val resumeRepositry: ResumeRepositry):ViewModel() {

    //getting list of resume as livedata
    val resumesList = resumeRepositry.resumesList.asLiveData()

    //inserting
    fun insert(entities: Entities){
        viewModelScope.launch {
            resumeRepositry.insert(entities)
        }
    }
    //deleting
    fun delete(entities: Entities){
        viewModelScope.launch {
            resumeRepositry.delete(entities)
        }
    }
    //updating
    fun update(entities: Entities){
        viewModelScope.launch {
            resumeRepositry.update(entities)
        }
    }


}