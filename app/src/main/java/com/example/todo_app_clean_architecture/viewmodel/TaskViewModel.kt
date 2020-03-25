package com.example.todo_app_clean_architecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Task
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase
import com.example.todo_app_clean_architecture.model.TaskItem
import com.example.todo_app_clean_architecture.model.TaskItemMapper
import java.lang.IllegalArgumentException

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskViewModel constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase
) : ViewModel() {


    private val _tasks = MutableLiveData<List<TaskItem>>()
    val tasks: LiveData<List<TaskItem>>
        get() = _tasks

    private val _addedTask = MutableLiveData<TaskItem>()
    val addedTask: LiveData<TaskItem>
        get() = _addedTask

    fun getTask() {
        val taskUseCase =getTaskUseCase.execute().map {
            TaskItemMapper.mapToItem(it)
        }
        _tasks.postValue(taskUseCase)
        Log.d("ViewModel",taskUseCase.size.toString())

    }

    fun createTask(title: String) {
        try {
            val addTaskUseCase = createTaskUseCase.execute(CreateTaskUseCase.Param(title))
            _addedTask.postValue(TaskItemMapper.mapToItem(addTaskUseCase))
            Log.d("ViewModel",addTaskUseCase.title)
        }catch (e: IllegalArgumentException){}
        catch (e: CreateTaskUseCase.InValidTaskError){}
    }
}