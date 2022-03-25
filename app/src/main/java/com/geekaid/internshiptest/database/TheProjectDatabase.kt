package com.geekaid.internshiptest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geekaid.internshiptest.model.TheProject

@Database(entities = [TheProject::class], version = 1, exportSchema = false)
abstract class TheProjectDatabase : RoomDatabase() {

    abstract fun theProjectDao(): TheProjectDao

    companion object {

        @Volatile
        private var INSTANCE: TheProjectDatabase? = null

        fun getDatabase(context: Context): TheProjectDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TheProjectDatabase::class.java,
                    "notes_database"
                ).build()
                INSTANCE = instance
                //return
                instance
            }
        }
    }
}