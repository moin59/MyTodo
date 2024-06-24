package com.example.entity

import jakarta.persistence.*

@Entity
@Table(name = "tasks")
data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name: String?
)