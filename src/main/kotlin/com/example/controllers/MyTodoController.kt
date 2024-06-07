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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Mono<MyTodo> {
        return myTodoRepository.findById(id)
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody myTodo: MyTodo): Mono<MyTodo> {
        val oldTodo = myTodoRepository.findById(id)
        println(oldTodo)

        if (oldTodo == null) {
            return myTodoRepository.save(myTodo)
        }else{
            return Mono.empty()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): Mono<MyTodo> {

        val oldTodo = myTodoRepository.findById(id)

        if (oldTodo != null) {
            return myTodoRepository.deleteById(id)
        }else{
            return Mono.empty()
        }

    }
}