package com.example.todo_app_clean_architecture.model

import com.example.domain.model.Task
import com.example.todo_app_clean_architecture.mapper.ItemMapper

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
data class TaskItem(
    val id :Int = 0,
    val title: String,
    val isDone : Boolean
):ItemModel()

object TaskItemMapper : ItemMapper<Task,TaskItem>{
    override fun mapToItem(domainModel: Task): TaskItem {
        return TaskItem(
            domainModel.id,
            domainModel.title,
            domainModel.isDone
        )
    }

    override fun mapToDomain(itemModel: TaskItem): Task {
        return Task(
            itemModel.id,
            itemModel.title,
            itemModel.isDone
        )
    }

}