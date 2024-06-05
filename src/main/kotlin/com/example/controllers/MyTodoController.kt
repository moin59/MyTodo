package com.example.controllers

import com.example.entities.MyTodo
import com.example.entities.MyTodoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/mytodos")
class MyTodoController(val myTodoRepository: MyTodoRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@RequestBody myToDo: MyTodo): Mono<MyTodo> {
        return myTodoRepository.save(myToDo)
    }
}