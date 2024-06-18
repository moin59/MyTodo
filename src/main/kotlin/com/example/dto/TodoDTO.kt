package com.example.dto


// service class a function er data type and return type hisebe use korar jonno
//  fun createTodo(todoDTO: TodoDTO): TodoDTO{...}
data class TodoDTO(
    val id: Int?,
    val title: String,
    val description: String
)