package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.ArticleDto
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<ArticleDto, Long>