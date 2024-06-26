package com.example.repository

import com.example.entity.Task
import org.springframework.data.repository.CrudRepository

interface TaskRespository: CrudRepository<Task, Int> {

}