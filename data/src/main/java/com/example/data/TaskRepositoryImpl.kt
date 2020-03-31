package com.example.data

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import io.reactivex.Single

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskRepositoryImpl(
    private val localDataSource: TaskRepository
) :TaskRepository {
    override fun getTask(): Single<List<Task>> {
        return localDataSource.getTask()
    }

    override fun insertTask(title: String, isDone: Boolean): Single<Task> {
        return localDataSource.insertTask(title,isDone)
    }

    override fun isExistTask(title: String): Single<Boolean> {
        return localDataSource.isExistTask(title)
    }
}