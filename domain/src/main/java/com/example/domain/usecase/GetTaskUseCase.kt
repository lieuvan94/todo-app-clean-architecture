package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class GetTaskUseCase constructor(
    private val taskRepository: TaskRepository
): WithoutParamUseCase<List<Task>>{

    /**
     * get latest 5 recent tasks
     */
    override fun execute(): List<Task> {
        return taskRepository.getTask().subList(0, MAXIMUM_TASK)
    }

    companion object{
        const val MAXIMUM_TASK = 5
    }

}