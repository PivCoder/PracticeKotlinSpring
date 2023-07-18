package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.service.api.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/author")
class AuthorController(private val authorService: AuthorService) {
    @GetMapping("/all")
    fun showAllArticles(): List<AuthorDto> {
        return authorService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneArticle(@PathVariable id: Long): Optional<AuthorDto> {
        return authorService.getById(id)
    }
}