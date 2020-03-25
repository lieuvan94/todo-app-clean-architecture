package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import java.lang.IllegalArgumentException

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class CreateTaskUseCase constructor(
    private val taskRepository: TaskRepository
): UseCase<CreateTaskUseCase.Param,Task> {

    /**
     * 1. Task can not be duplicate
     */
    override fun execute(param: Param): Task {

        try {
            val title = param.title
            val isValid = inValidTitle(title)
            if(isValid){
                return taskRepository.insertTask(title,param.isDone)
            }
            throw UnknownError()
        }catch (error :InValidTaskError){
            throw error
        }

    }

    private fun inValidTitle(title: String): Boolean{

        if (title.isEmpty()){
            throw IllegalArgumentException(TITLE_EMPTY)
        }

        if(taskRepository.isExistTask(title)){
            throw InValidTaskError(TASK_EXIST)
        }

        return true
    }

    companion object{
        const val TASK_EXIST = "Task is exist"
        const val TITLE_EMPTY = "Title must not be empty"
    }

    data class Param(val title:String,val isDone :Boolean = false)

    class InValidTaskError( error: String): Error(error)
}
