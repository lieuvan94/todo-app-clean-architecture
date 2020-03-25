package com.example.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.local.model.TaskEntity.Companion.TASK_TABLE
import com.example.data.mapper.EntityMapper
import com.example.domain.model.Task

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
@Entity(tableName = TASK_TABLE)
data class TaskEntity(
    @PrimaryKey
    @ColumnInfo(name = FILED_ID) val id : Int,
    @ColumnInfo(name = FILED_TITLE) val title: String,
    @ColumnInfo(name = FILED_IS_DONE) val isDone: Boolean
) : EntityModel(){
    companion object{
        const val TASK_TABLE = "TaskTable"
        const val FILED_ID = "id"
        const val FILED_TITLE = "title"
        const val FILED_IS_DONE = "isDone"
    }
}

object TaskEntityMapper : EntityMapper<Task, TaskEntity> {
    override fun mapToEntity(domainModel: Task): TaskEntity {
        return TaskEntity(
            id = domainModel.id,
            title = domainModel.title,
            isDone = domainModel.isDone
        )
    }

    override fun mapToDomain(entityModel: TaskEntity): Task {
        return Task(
            id = entityModel.id,
            title = entityModel.title,
            isDone = entityModel.isDone
        )
    }

}