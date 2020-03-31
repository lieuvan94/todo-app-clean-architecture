package com.example.todo_app_clean_architecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase
import com.example.todo_app_clean_architecture.model.TaskItem
import com.example.todo_app_clean_architecture.model.TaskItemMapper
import com.example.todo_app_clean_architecture.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskViewModel constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _tasks = MutableLiveData<List<TaskItem>>()
    val tasks: LiveData<List<TaskItem>>
        get() = _tasks

    private val _addedTask = MutableLiveData<TaskItem>()
    val addedTask: LiveData<TaskItem>
        get() = _addedTask

    fun getTask() {
        val disposable = getTaskUseCase.execute()
            .flatMapIterable { it }
            .map {
                TaskItemMapper.mapToItem(it)
            }.subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .toList()
            .subscribe({ tasks ->
                _tasks.postValue(tasks)
                Log.d("ViewModel", tasks.size.toString())
            }, { error ->
                Log.d("ViewModel", error.message.toString())
            })
        compositeDisposable.add(disposable)

    }

    fun createTask(title: String) {

        val disposable = createTaskUseCase.execute(CreateTaskUseCase.Param(title))
            .map {
                TaskItemMapper.mapToItem(it)
            }.subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({ task ->
                _addedTask.postValue(task)
            }, { error ->
                Log.d("ViewModel", error.message.toString())
            })

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}