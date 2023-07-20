package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.service.api.AuthorService
import org.springframework.web.bind.annotation.*
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

    @PostMapping("/create")
    fun createArticle(@RequestBody authorDto: AuthorDto) : Author {
        return authorService.add(authorDto);
    }
}