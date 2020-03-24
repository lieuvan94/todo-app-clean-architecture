package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class CreateTaskUseCase constructor(
    private val taskRepository: TaskRepository
): UseCase<CreateTaskUseCase.Param,Task> {

    /**
     * 1. Task must start with "Make money"
     * 2. Maximum character = 500
     * 3. Min character = 10
     * 4. Task can not be duplicate
     */
    override fun execute(param: Param): Task {

        try {
            val title = param.title
            val isValid = inValidTitle(title)
            if(isValid){
                return taskRepository.createTask(title,param.isDone)
            }
            throw UnknownError()
        }catch (error :InValidTaskError){
            throw error
        }

    }

    private fun inValidTitle(title: String): Boolean{

        if(!title.startsWith(TITLE_PREFIX)){
            throw InValidTaskError(ERROR_PREFIX)
        }
        if(title.length> TITLE_MAX_LENGTH){
            throw InValidTaskError(ERROR_MAX_CHARACTER)
        }
        if(title.length< TITLE_MIN_LENGTH){
            throw InValidTaskError(ERROR_MIN_CHARACTER)
        }
        if(taskRepository.isExistTask(title)){
            throw DuplicateTaskError()
        }

        return true
    }

    companion object{
        const val TITLE_PREFIX = "Make money"
        const val TITLE_MIN_LENGTH = 10
        const val TITLE_MAX_LENGTH = 500
        const val ERROR_PREFIX = "Task name must be start with $TITLE_PREFIX"
        const val ERROR_MIN_CHARACTER = "Task name must be start with $TITLE_MIN_LENGTH"
        const val ERROR_MAX_CHARACTER = "Task name must be start with $TITLE_MAX_LENGTH"
    }

    data class Param(val title:String,val isDone :Boolean = false)
}

class InValidTaskError( error: String): Error(error)
class DuplicateTaskError: Error()