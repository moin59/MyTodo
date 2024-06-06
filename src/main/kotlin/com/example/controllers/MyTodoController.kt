package com.example.controllers

import com.example.entities.MyTodo
import com.example.entities.MyTodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/todos", produces = [MediaType.APPLICATION_JSON_VALUE])
class MyTodoController {

    @Autowired
    lateinit var myTodoRepository: MyTodoRepository

    @PostMapping
    fun createTodo(@RequestBody myToDo: MyTodo): Mono<MyTodo> {
        return myTodoRepository.save(myToDo)
    }

    @GetMapping
    fun findAll(): Flux<MyTodo> {
        return myTodoRepository.findAll()
    }
}