package com.example.data.local

import com.example.data.local.model.TaskEntity
import com.example.data.local.model.TaskEntityMapper
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import java.util.*

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskLocalDataSource constructor(
    private val taskDAO: TaskDAO
): TaskRepository{

    override fun getTask(): List<Task> {
        return taskDAO.getTask().map {
            TaskEntityMapper.mapToDomain(it)
        }
    }

    override fun insertTask(title: String, isDone: Boolean): Task {
        val id = Random().nextInt(100)
        val task = TaskEntity(id,title,isDone)
        taskDAO.insertTask(task)
        return  TaskEntityMapper.mapToDomain(task)
    }

    override fun isExistTask(title: String): Boolean {
        return taskDAO.countTask(title)>0
    }

}