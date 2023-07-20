package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.service.api.ArticleService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/article")
class ArticleController(private val articleService: ArticleService) {
    @GetMapping("/all")
    fun showAllArticles(): List<ArticleDto> {
        return articleService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneArticle(@PathVariable id: Long): Optional<ArticleDto> {
        return articleService.getById(id)
    }

    @PostMapping("/create")
    fun createArticle(@RequestBody articleDto: ArticleDto) : Article {
        return articleService.add(articleDto);
    }
}