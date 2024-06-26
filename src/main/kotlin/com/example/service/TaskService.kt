package com.example.service

import com.example.dto.TaskDTO
import com.example.entity.Task
import com.example.repository.TaskRespository
import org.springframework.stereotype.Service

@Service
class TaskService(val taskRespository: TaskRespository) {

    fun createTask(taskDTO: TaskDTO): TaskDTO {

       val taskEntity = taskDTO.let {
            Task(it.id, it.name)
        }

        taskRespository.save(taskEntity)

        return taskEntity.let {
            TaskDTO(it.id, it.name)
        }
    }
}
