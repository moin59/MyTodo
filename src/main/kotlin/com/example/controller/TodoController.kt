package com.example.controller

import com.example.dto.TodoDTO
import com.example.entity.Todo

import com.example.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/todos")
class TodoController(val todoService: TodoService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@RequestBody todoDTO: TodoDTO): TodoDTO {
        return todoService.createTodo(todoDTO)
    }

    @GetMapping
    fun getAllTodos(): List<TodoDTO> = todoService.getAllTodos()

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable("id") id: Int): Optional<Todo> {
        return todoService.getTodo(id)
    }

    @PutMapping("/{id}")
    fun updateTodo(@RequestBody todoDTO: TodoDTO, @PathVariable("id") id: Int): TodoDTO {
        return todoService.updateTodo(id, todoDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTodo(@PathVariable("id") id: Int): Any {

        return todoService.deleteTodo(id)
    }
}