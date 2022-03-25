package com.geekaid.internshiptest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.geekaid.internshiptest.model.TheProject

@Dao
interface TheProjectDao{

    @Insert
    suspend fun insert(data: TheProject)

    @Delete
    suspend fun delete(data: TheProject)

    @Query("SELECT * FROM yes_thats_me ORDER BY id ASC")
    fun getAllData(): LiveData<List<TheProject>>
}