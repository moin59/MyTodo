package com.example.entity

import jakarta.persistence.*

// database a table, collumn create korar jonno
@Entity
@Table(name = "todos")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var title: String,
    var description: String,

    @OneToMany(
        mappedBy = "todo",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )

    var tasks: List<Task> = mutableListOf()
)