package com.example.repository

import com.example.entity.Todo
import org.springframework.data.repository.CrudRepository

// service class er data type -> class TodoService(val todoRepository: TodoRepository){..}
interface TodoRepository : CrudRepository<Todo, Int> {

    fun findByTitleContaining(title: String): List<Todo>
}