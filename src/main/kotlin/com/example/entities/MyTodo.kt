package com.example.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@jakarta.persistence.Table (name="todo")
@Entity
class MyTodo {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null

    var title: String? = null
    var completed: Boolean? = false



}