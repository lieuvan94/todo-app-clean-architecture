package com.example.domain.repository

import com.example.domain.model.Task
import io.reactivex.Single

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
interface TaskRepository : Repository{

    fun getTask():Single<List<Task>>

    fun insertTask(title :String, isDone: Boolean = false) : Single<Task>

    fun isExistTask(title: String) : Single<Boolean>
}