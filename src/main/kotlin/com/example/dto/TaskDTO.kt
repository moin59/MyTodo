package com.example.dto

import jakarta.validation.constraints.NotBlank

data class TaskDTO(
    val id: Int?,

    @get: NotBlank(message = "taskDto.name must not be blank")
    val name: String
)
