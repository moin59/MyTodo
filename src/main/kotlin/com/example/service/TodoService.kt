package com.example.service

import com.example.dto.TodoDTO
import com.example.entity.Todo
import com.example.exception.TodoNotFoundException
import com.example.repository.TodoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoService(val todoRepository: TodoRepository) {

    fun createTodo(todoDTO: TodoDTO): TodoDTO{

        val todoEntity = todoDTO.let {
            Todo(null, it.title, it.description)
        }

        todoRepository.save(todoEntity)

        return todoEntity.let {
            TodoDTO(it.id, it.title.toString(), it.description.toString())
        }
    }

    fun getAllTodos(todoTitle: String?): List<TodoDTO>{

        val todo =todoTitle?.let {
            todoRepository.findTodoByTitle(todoTitle)
        } ?: todoRepository.findAll()

        return todoRepository.findAll().map {
            TodoDTO(it.id, it.title.toString(), it.description.toString())
        }
    }

    fun getTodo(id: Int): Optional<Todo> {
        return todoRepository.findById(id)
    }

    fun updateTodo(id: Int, todoDTO: TodoDTO): TodoDTO {

        val existingTodo = todoRepository.findById(id)

        return if(existingTodo.isPresent){
            existingTodo.get().let {
                it.title = todoDTO.title
                it.description = todoDTO.description
                todoRepository.save(it)
                TodoDTO(it.id, it.title.toString(), it.description.toString())
            }
        }else{
            throw TodoNotFoundException("No Todo found for the id: $id")
        }
    }

    fun deleteTodo(id: Int): Any {

        val existingTodo = todoRepository.findById(id)

        return if(existingTodo.isPresent){
            existingTodo.get().let {
                todoRepository.delete(it)
            }
        }else{
            throw Exception("Todo not found")
        }
    }

    fun findByTodoId(todoId: Int): Optional<Todo> {

       return todoRepository.findById(todoId)

    }
}