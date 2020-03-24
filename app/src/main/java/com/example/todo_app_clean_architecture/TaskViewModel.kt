package com.example.todo_app_clean_architecture

import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskViewModel constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase
) {
    fun getTask(){
        getTaskUseCase.execute()
    }

    fun createTask(title:String){
        createTaskUseCase.execute(CreateTaskUseCase.Param(title))
    }
}