package com.example.entities

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MyTodoRepository : R2dbcRepository<MyTodo, Int> {

    fun findById(id: Long):Mono<MyTodo>

    @Query("SELECT * FROM todos")
    fun findAllTodos(limit: Int, offset: Int): Flux<MyTodo>
}