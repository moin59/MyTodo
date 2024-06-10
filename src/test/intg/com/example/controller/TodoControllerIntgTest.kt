package com.example.controller

import com.example.dto.TodoDTO
import com.example.repository.TodoRepository
import com.example.util.todoEntityList
import org.junit.jupiter.api.Assertions
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
}