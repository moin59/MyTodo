package com.example.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class TaskDTO(
    val id: Int?,

    @get: NotBlank(message = "taskDto.name must not be blank")
    val name: String,

    @get: NotNull(message = "taskDto.todoId must not be null")
    val todoId: Int? = null
)