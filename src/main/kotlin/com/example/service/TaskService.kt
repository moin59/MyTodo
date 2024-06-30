package com.example.service

import com.example.dto.TaskDTO
import com.example.entity.Task
import com.example.exception.TodoNotValidException
import com.example.repository.TaskRespository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class TaskService(val taskRespository: TaskRespository,
    val todoService: TodoService) {

    companion object: KLogging()

    fun createTask(taskDTO: TaskDTO): TaskDTO {

        val taskOptional = todoService.findByTodoId(taskDTO.todoId!!)
        if(!taskOptional.isPresent) {
            throw TodoNotValidException("Todo not valid")
        }

       val taskEntity = taskDTO.let {
            Task(it.id, it.name, taskOptional.get())
        }

        taskRespository.save(taskEntity)
        logger.info("Saved task is: $taskEntity")

        return taskEntity.let {
            TaskDTO(it.id, it.name, it.todo!!.id)
        }
    }
}
