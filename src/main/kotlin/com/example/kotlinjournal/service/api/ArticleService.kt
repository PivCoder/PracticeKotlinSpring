package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.ArticleDto

interface ArticleService {
    fun add(articleDto: ArticleDto): ArticleDto
    fun getById(id: Long): ArticleDto
    fun deleteById(id: Long)
    fun edit(articleDto: ArticleDto): ArticleDto
    fun getAll(): List<ArticleDto>
}