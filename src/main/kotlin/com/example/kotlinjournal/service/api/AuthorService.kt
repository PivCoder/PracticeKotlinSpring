package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.model.Author
import java.util.*

interface AuthorService {
    fun add(authorDto: AuthorDto): Author
    fun getById(id: Long): Optional<AuthorDto>
    fun deleteById(id: Long)
    fun edit(authorDto: AuthorDto)
    fun getAll(): List<AuthorDto>
}