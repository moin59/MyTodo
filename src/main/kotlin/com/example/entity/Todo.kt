package com.example.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "todos")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var title: String?,
    var description: String?
)