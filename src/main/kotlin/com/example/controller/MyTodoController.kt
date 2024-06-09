package com.example.controller

import com.example.dto.MyTodoDTO
import com.example.entity.MyTodo

import com.example.service.MyTodoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/todos")
class MyTodoController(val myTodoService: MyTodoService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@RequestBody myTodoDTO: MyTodoDTO): MyTodoDTO {
        return myTodoService.createTodo(myTodoDTO)
    }

    @GetMapping
    fun getAllTodos(): List<MyTodoDTO> = myTodoService.getAllTodos()

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable("id") id: Int): Optional<MyTodo> {
        return myTodoService.getTodo(id)
    }

    @PutMapping("/{id}")
    fun updateTodo(@RequestBody myTodoDTO: MyTodoDTO, @PathVariable("id") id: Int): MyTodoDTO {
        return myTodoService.updateTodo(id, myTodoDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTodo(@PathVariable("id") id: Int): Any {

        return myTodoService.deleteTodo(id)
    }
}