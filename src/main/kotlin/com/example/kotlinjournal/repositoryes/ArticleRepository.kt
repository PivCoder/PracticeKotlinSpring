package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long>