package com.example.entities



import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("todos")
data class MyTodo (

    @Id
    var id: Long? = null,
    var title: String? = null,
    var description: String? = null

)