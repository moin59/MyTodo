package com.example.dto
import jakarta.validation.constraints.NotBlank


// service class a function er data type and return type hisebe use korar jonno
//  fun createTodo(todoDTO: TodoDTO): TodoDTO{...}
data class TodoDTO(
    val id: Int?,

    @get: NotBlank(message = "todoDto.title must not be blank")
    val title: String,

    @get: NotBlank(message = "todoDto.description must not be blank")
    val description: String,

)