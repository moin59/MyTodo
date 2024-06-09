package com.example.service

import com.example.dto.MyTodoDTO
import com.example.entity.MyTodo
import com.example.repository.MyTodoRepository
import org.springframework.stereotype.Service

@Service
class MyTodoService(val myTodoRepository: MyTodoRepository) {


    fun createTodo(myTodoDTO: MyTodoDTO): MyTodoDTO{

        val todoEntity = myTodoDTO.let {
            MyTodo(null, it.title, it.description)
        }
        myTodoRepository.save(todoEntity)

        return todoEntity.let {
            MyTodoDTO(it.id, it.title.toString(), it.description.toString())
        }
    }
}