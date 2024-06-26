package com.example.controller

import com.example.dto.TaskDTO
import com.example.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/tasks")
@Validated
class TaskController(val taskService: TaskService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody taskDTO: TaskDTO) = taskService.createTask(taskDTO)

}