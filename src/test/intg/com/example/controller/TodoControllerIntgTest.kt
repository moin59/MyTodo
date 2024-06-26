package com.example.controller

import com.example.dto.TodoDTO
import com.example.entity.Todo
import com.example.repository.TodoRepository
import com.example.util.todoEntityList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class TodoControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var todoRepository: TodoRepository

    @BeforeEach
    fun setUp() {
        todoRepository.deleteAll()
        val myTodo = todoEntityList()
        todoRepository.saveAll(myTodo)
    }

    @Test
    fun addTodoTest() {
        val todoDTO = TodoDTO(1, "Test todo", "Test Description")

        val savedTodoDTO = webTestClient
            .post()
            .uri("/todos")
            .bodyValue(todoDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(TodoDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue{
            savedTodoDTO!!.id != null
        }
    }

    @Test
    fun getAllTodosTest() {
        val todoDTOs = webTestClient
            .get()
            .uri("/todos")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(TodoDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(3, todoDTOs!!.size)

    }

    @Test
    fun updateTodoTest() {
        val todo = Todo(null, "Test todo", "Test Description")
        todoRepository.save(todo)
        val todoDTO = TodoDTO(null, "Test todo1", "Test Description")

        val updatedTodoDTO = webTestClient
            .put()
            .uri("/todos/{id}", todo.id)
            .bodyValue(todoDTO)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(TodoDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Test todo", todo!!.title)
    }

    @Test
    fun deleteTodoTest() {
        val todo = Todo(1, "Test todo", "Test Description")
        todoRepository.save(todo)

        val updatedTodo = webTestClient
            .delete()
            .uri("/todos/{id}", todo.id)
            .exchange()
            .expectStatus().isNoContent
    }
}