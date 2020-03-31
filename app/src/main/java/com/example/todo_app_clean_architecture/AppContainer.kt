package com.example.todo_app_clean_architecture

import android.app.Application
import com.example.data.TaskRepositoryImpl
import com.example.data.local.TaskDatabase
import com.example.data.local.TaskLocalDataSource
import com.example.data.local.model.TaskEntityMapper
import com.example.domain.repository.TaskRepository
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase
import com.example.todo_app_clean_architecture.model.TaskItemMapper
import com.example.todo_app_clean_architecture.utils.rx.SchedulerProvider
import com.example.todo_app_clean_architecture.utils.rx.SchedulerProviderImpl
import com.example.todo_app_clean_architecture.viewmodel.TaskViewModel
import com.example.todo_app_clean_architecture.viewmodel.TaskViewModelFactory

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class AppContainer constructor(
    application: Application
){
    private val taskDatabase:TaskDatabase by lazy {
        TaskDatabase.getInstance(application)
    }

    private val taskLocalDataSource: TaskLocalDataSource by lazy {
        TaskLocalDataSource(taskDatabase.taskDAO())
    }
    private val taskRepository : TaskRepository by lazy {
        TaskRepositoryImpl(taskLocalDataSource)
    }

    private val createTaskUseCase : CreateTaskUseCase by lazy {
        CreateTaskUseCase(taskRepository)
    }
    private val getTaskUseCase : GetTaskUseCase by lazy {
        GetTaskUseCase(taskRepository)
    }

    private val schedulerProvider :SchedulerProvider by lazy {
        SchedulerProviderImpl()
    }

    private val _taskViewModelFactory = TaskViewModelFactory(createTaskUseCase, getTaskUseCase,schedulerProvider)

    val taskViewModelFactory : TaskViewModelFactory get() = _taskViewModelFactory


}