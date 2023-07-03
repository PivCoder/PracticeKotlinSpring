package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long>{
    //TODO посмотреть работает ли
    fun findByName(name: String)
}