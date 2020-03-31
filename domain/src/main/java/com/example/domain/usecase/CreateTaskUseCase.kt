package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import io.reactivex.Observable
import io.reactivex.Single
import kotlin.IllegalArgumentException

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class CreateTaskUseCase constructor(
    private val taskRepository: TaskRepository
): UseCase<CreateTaskUseCase.Param,Task> {

    /**
     * 1. Task can not be duplicate
     */
    override fun execute(param: Param): Observable<Task> {

        return Single.just(param.title).flatMap { title ->
            if (title.isEmpty()){
                Single.error(IllegalArgumentException(TITLE_EMPTY))
            }else{
                taskRepository.isExistTask(title)
            }
        }.flatMap { isExist ->
            if (isExist){
                Single.error(InValidTaskError(TASK_EXIST))
            }else{
                taskRepository.insertTask(param.title,param.isDone)
            }
        }.toObservable()

    }


    companion object{
        const val TASK_EXIST = "Task is exist"
        const val TITLE_EMPTY = "Title must not be empty"
    }

    data class Param(val title:String,val isDone :Boolean = false)

    class InValidTaskError( error: String): Error(error)
}
