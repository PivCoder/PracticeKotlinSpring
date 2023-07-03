package com.example.kotlinSpringInitialization.service.api

import com.example.kotlinSpringInitialization.model.Article
import java.util.*

interface ArticleService {
    fun addArticle(article: Article): Article
    fun getArticleById(id: Long): Optional<Article>
    fun deleteArticleById(id: Long)
    fun editArticle(article: Article)
    fun getAllArticles(): List<Article>
}