package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class GetTaskUseCase constructor(
    private val taskRepository: TaskRepository
): WithoutParamUseCase<List<Task>>{

    override fun execute(): List<Task> {
        return taskRepository.getTask()
    }

}