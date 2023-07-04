package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Article
import java.util.*

interface ArticleService {
    fun add(article: Article): Article
    fun getById(id: Long): Optional<Article>
    fun deleteById(id: Long)
    fun edit(article: Article)
    fun getAll(): List<Article>
}