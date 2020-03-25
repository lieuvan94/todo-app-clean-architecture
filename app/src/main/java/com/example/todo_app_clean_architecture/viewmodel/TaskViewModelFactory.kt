package com.example.todo_app_clean_architecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

/**
 * Created by Nguyen Văn Lieu on 3/25/2020
 */

class TaskViewModelFactory constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(createTaskUseCase, getTaskUseCase) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

}