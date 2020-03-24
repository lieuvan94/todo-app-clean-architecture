package com.example.data.local

import com.example.data.mapper.Mapper
import com.example.data.local.model.TaskEntity
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import java.util.*

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskLocalDataSource constructor(
    private val taskDAO: TaskDAO,
    private val mapper: Mapper<Task,TaskEntity>
): TaskRepository{

    override fun getTask(): List<Task> {
        return taskDAO.getTask().map {
            mapper.mapToDomain(it)
        }
    }

    override fun createTask(title: String, isDone: Boolean): Task {
        val id = UUID.randomUUID().toString().subSequence(0,10).toString()
        val task = TaskEntity(id,title,isDone)
        taskDAO.createTask(task)
        return mapper.mapToDomain(task)
    }

    override fun isExistTask(title: String): Boolean {
        return taskDAO.isExist(title)!=null
    }

}