package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Author
import java.util.*

interface UserService {
    fun add(author: Author): Author
    fun getById(id: Long): Optional<Author>
    fun deleteById(id: Long)
    fun edit(author: Author)
    fun getAll(): List<Author>
}