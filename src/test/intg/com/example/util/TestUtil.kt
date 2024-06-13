package com.example.util

import com.example.entity.Todo

fun todoEntityList() = listOf(
    Todo(null, "New Todo", "Test Description"),
    Todo(null, "Second Todo", "Test Description"),
    Todo(null, "Wiremock for Java Developers", "Development")
)