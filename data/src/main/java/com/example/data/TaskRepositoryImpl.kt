package com.example.data

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskRepositoryImpl(
    private val localDataSource: TaskRepository
) :TaskRepository {
    override fun getTask(): List<Task> {
        return localDataSource.getTask()
    }

    override fun createTask(title: String, isDone: Boolean): Task {
        return localDataSource.createTask(title,isDone)
    }

    override fun isExistTask(title: String): Boolean {
        return localDataSource.isExistTask(title)
    }
}