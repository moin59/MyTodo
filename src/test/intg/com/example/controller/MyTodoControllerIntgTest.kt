package com.example.controller

import com.example.dto.MyTodoDTO
import com.example.repository.MyTodoRepository
import com.example.util.myTodoEntityList
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
class MyTodoControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var myTodoRepository: MyTodoRepository

    @BeforeEach
    fun setUp() {
        myTodoRepository.deleteAll()
        val myTodo = myTodoEntityList()
        myTodoRepository.saveAll(myTodo)
    }

    @Test
    fun addTodoTest() {
        val myTodoDTO = MyTodoDTO(1, "Test todo", "Test Description")

        val savedMyTodoDTO = webTestClient
            .post()
            .uri("/todos")
            .bodyValue(myTodoDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(MyTodoDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue{
            savedMyTodoDTO!!.id != null
        }
    }
}