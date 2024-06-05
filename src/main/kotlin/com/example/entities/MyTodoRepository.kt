package com.example.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.CrudRepository

interface MyTodoRepository : R2dbcRepository<MyTodo, Int> {
}