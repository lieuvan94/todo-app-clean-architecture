package com.example.todo_app_clean_architecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase
import com.example.todo_app_clean_architecture.utils.rx.SchedulerProvider

/**
 * Created by Nguyen Văn Lieu on 3/25/2020
 */

class TaskViewModelFactory constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val schedulerProvider : SchedulerProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(createTaskUseCase, getTaskUseCase,schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

}