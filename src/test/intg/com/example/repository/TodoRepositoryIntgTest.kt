package com.example.repository

import com.example.entity.Todo
import com.example.util.todoEntityList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
class TodoRepositoryIntgTest {

    @Autowired
    lateinit var todoRepository: TodoRepository

    @BeforeEach
    fun setUp() {
        todoRepository.deleteAll()
        val todo = todoEntityList()
        todoRepository.saveAll(todo)
    }

    @Test
    fun findByTitleContaining() {

        val todos = todoRepository.findByTitleContaining("New Todo")
        println("todos: $todos")

        Assertions.assertEquals(1, todos.size)

    }

    @Test
    fun findTodoByTitle() {

        val todos = todoRepository.findTodoByTitle("New Todo")
        println("todos: $todos")

        Assertions.assertEquals(1, todos.size)

    }


}