package com.example.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.local.model.TaskEntity.Companion.TASK_TABLE

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
@Entity(tableName = TASK_TABLE)
data class TaskEntity(
    @PrimaryKey
    @ColumnInfo(name = FILED_ID) val id : String,
    @ColumnInfo(name = FILED_TITLE) val title: String,
    @ColumnInfo(name = FILED_IS_DONE) val isDone: Boolean
){
    companion object{
        const val TASK_TABLE = "TaskTable"
        const val FILED_ID = "id"
        const val FILED_TITLE = "title"
        const val FILED_IS_DONE = "isDone"
    }
}