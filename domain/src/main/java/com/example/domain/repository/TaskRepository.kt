package com.example.domain.repository

import com.example.domain.model.Task

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
interface TaskRepository {

    fun getTask():List<Task>

    fun insertTask(title :String, isDone: Boolean = false) : Task

    fun isExistTask(title: String) : Boolean
}