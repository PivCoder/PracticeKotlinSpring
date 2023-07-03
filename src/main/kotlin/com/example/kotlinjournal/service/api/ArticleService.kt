package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Article
import java.util.*

interface ArticleService {
    fun addArticle(article: Article): Article
    fun getArticleById(id: Long): Optional<Article>
    fun deleteArticleById(id: Long)
    fun editArticle(article: Article)
    fun getAllArticles(): List<Article>
}