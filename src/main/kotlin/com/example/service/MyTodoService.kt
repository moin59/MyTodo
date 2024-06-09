package com.example.service

import com.example.dto.MyTodoDTO
import com.example.entity.MyTodo
import com.example.repository.MyTodoRepository
import org.springframework.stereotype.Service
import java.util.*

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

    fun getAllTodos(): List<MyTodoDTO>{
        return myTodoRepository.findAll().map {
            MyTodoDTO(it.id, it.title.toString(), it.description.toString())
        }
    }

    fun getTodo(id: Int): Optional<MyTodo> {
        return myTodoRepository.findById(id)
    }

    fun updateTodo(id: Int, myTodoDTO: MyTodoDTO): MyTodoDTO {

        val existingTodo = myTodoRepository.findById(id)

        return if(existingTodo.isPresent){
            existingTodo.get().let {
                it.title = myTodoDTO.title
                it.description = myTodoDTO.description
                myTodoRepository.save(it)
                MyTodoDTO(it.id, it.title.toString(), it.description.toString())
            }
        }else{
            throw Exception("Todo not found")
        }
    }

    fun deleteTodo(id: Int): Any {

        val existingTodo = myTodoRepository.findById(id)

        return if(existingTodo.isPresent){
            existingTodo.get().let {
                myTodoRepository.delete(it)
            }
        }else{
            throw Exception("Todo not found")
        }
    }
}