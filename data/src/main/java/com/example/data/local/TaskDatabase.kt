package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.TaskDatabase.Companion.DATABASE_NAME
import com.example.data.local.TaskDatabase.Companion.DATABASE_VERSION
import com.example.data.local.model.TaskEntity

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
@Database(entities = [TaskEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDAO(): TaskDAO

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "db_task"

        private var instance: TaskDatabase? = null
        fun getInstance(context: Context): TaskDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    TaskDatabase::class.java,
                    DATABASE_NAME
                ).allowMainThreadQueries().build()
            }
            return instance as TaskDatabase
        }

    }
}