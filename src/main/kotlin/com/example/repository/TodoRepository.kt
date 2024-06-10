package com.example.repository

import com.example.entity.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository : CrudRepository<Todo, Int> {
}