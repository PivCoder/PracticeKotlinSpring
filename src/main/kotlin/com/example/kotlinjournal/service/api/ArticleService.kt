package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.model.Article
import java.util.*

interface ArticleService {
    fun add(articleDto: ArticleDto): Article
    fun getById(id: Long): Optional<ArticleDto>
    fun deleteById(id: Long)
    fun edit(articleDto: ArticleDto)
    fun getAll(): List<ArticleDto>
}