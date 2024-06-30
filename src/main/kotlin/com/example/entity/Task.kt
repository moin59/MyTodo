package com.example.entity

import jakarta.persistence.*

@Entity
@Table(name = "tasks")
data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoId", nullable = false)
    val todo: Todo? = null
)
{
    override fun toString(): String {
        return "Task(id=$id, name='$name', todo='${todo!!.id}')"
    }
}