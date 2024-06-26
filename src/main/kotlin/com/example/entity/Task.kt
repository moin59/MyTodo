package com.example.entity

import jakarta.persistence.*

@Entity
@Table(name = "tasks")
data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    var todo: Todo? = null
)