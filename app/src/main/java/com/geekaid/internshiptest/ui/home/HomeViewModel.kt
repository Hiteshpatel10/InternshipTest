package com.geekaid.internshiptest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geekaid.internshiptest.database.TheProjectDao
import com.geekaid.internshiptest.model.TheProject
import com.geekaid.internshiptest.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(theProjectDao: TheProjectDao) : ViewModel() {

    private val repository = Repository(theProjectDao)

    fun insert(data: TheProject){
        viewModelScope.launch {
            repository.insert(data)
        }
    }

    fun delete(data: TheProject){
        viewModelScope.launch {
            repository.delete(data)
        }
    }
    val allData = repository.allData
}