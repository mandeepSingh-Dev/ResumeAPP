package com.example.resumeapp.RoomClasses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewmodelFactory(val resumeRepositry: ResumeRepositry):ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(resumeRepositry) as T
    }
}