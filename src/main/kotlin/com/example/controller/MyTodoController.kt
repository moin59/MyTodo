package com.example.controller

import com.example.dto.MyTodoDTO

import com.example.service.MyTodoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/todos")
class MyTodoController(val myTodoService: MyTodoService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@RequestBody myTodoDTO: MyTodoDTO): MyTodoDTO {
        return myTodoService.createTodo(myTodoDTO)
    }

//    @GetMapping
//    fun getAllTodos(): MutableIterable<MyTodo> = myTodoService.getAllTodos()



//    fun findAll(): Flux<MyTodo> {
//        return myTodoRepository.findAll()
//    }

//    @GetMapping("/{id}")
//    fun findById(@PathVariable id: Long): Mono<MyTodo> {
//        return myTodoRepository.findById(id)
//    }
//
//    @PutMapping("/{id}")
//    fun updateTodo(@PathVariable id: Long, @RequestBody myTodo: MyTodo): Mono<MyTodo> {
//        val oldTodo = myTodoRepository.findById(id)
//        println(oldTodo)
//
//        if (oldTodo == null) {
//            return myTodoRepository.save(myTodo)
//        }else{
//            return Mono.empty()
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteTodo(@PathVariable id: Long): Mono<MyTodo> {
//
//        val oldTodo = myTodoRepository.findById(id)
//
//        if (oldTodo != null) {
//            return myTodoRepository.deleteById(id)
//        }else{
//            return Mono.empty()
//        }
//
//    }
}