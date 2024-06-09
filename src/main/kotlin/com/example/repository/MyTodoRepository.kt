package com.example.repository

import com.example.entity.MyTodo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface MyTodoRepository : CrudRepository<MyTodo, Int> {
}