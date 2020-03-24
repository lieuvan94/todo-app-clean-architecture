package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.model.TaskEntity
import com.example.data.local.model.TaskEntity.Companion.FILED_TITLE
import com.example.data.local.model.TaskEntity.Companion.TASK_TABLE

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
@Dao
interface TaskDAO{

    @Query("select * from $TASK_TABLE")
    fun getTask(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createTask(task: TaskEntity)

    @Query("select * from $TASK_TABLE where $FILED_TITLE=:title" )
    fun isExist(title :String): TaskEntity?
}