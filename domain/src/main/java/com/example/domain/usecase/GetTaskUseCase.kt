package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class GetTaskUseCase constructor(
    private val taskRepository: TaskRepository
): WithoutParamUseCase<List<Task>>{

    override fun execute(): Observable<List<Task>> {
        return taskRepository.getTask().toObservable()
    }

}