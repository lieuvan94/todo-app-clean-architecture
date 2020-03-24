package com.example.data.mapper

import com.example.data.local.model.TaskEntity
import com.example.domain.model.Task

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class MapperTaskEntityToDomain :Mapper<Task,TaskEntity>{
    override fun mapToDomain(data: TaskEntity): Task {
        return Task(
            data.id,
            data.title,
            data.isDone
        )
    }

    override fun mapToData(domain: Task): TaskEntity {
        return TaskEntity(
            domain.id,
            domain.title,
            domain.isDone
        )
    }
}