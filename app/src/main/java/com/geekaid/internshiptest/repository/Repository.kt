package com.geekaid.internshiptest.repository

import com.geekaid.internshiptest.database.TheProjectDao
import com.geekaid.internshiptest.model.TheProject


class Repository(private val theProjectDao: TheProjectDao){

    suspend fun insert(data: TheProject){
        theProjectDao.insert(data = data)
    }

    suspend fun delete(data: TheProject){
        theProjectDao.delete(data = data)
    }

    val allData = theProjectDao.getAllData()
}