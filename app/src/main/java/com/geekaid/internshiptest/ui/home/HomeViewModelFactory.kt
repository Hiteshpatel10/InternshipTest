package com.geekaid.internshiptest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geekaid.internshiptest.database.TheProjectDao

class HomeViewModelFactory(private val theProjectDao: TheProjectDao): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(theProjectDao) as T
        }
        throw IllegalArgumentException("NotesAddViewModel: Unknown Error")
    }
}