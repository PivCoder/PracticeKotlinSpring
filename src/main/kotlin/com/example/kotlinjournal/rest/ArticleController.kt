package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.service.api.ArticleService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/article")
class ArticleController(private val articleService: ArticleService) {
    @GetMapping
    fun showAll(): List<ArticleDto> {
        return articleService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<ArticleDto> {
        return articleService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody articleDto: ArticleDto) : ArticleDto {
        return articleService.add(articleDto);
    }

    @PutMapping
    fun update(@RequestBody articleDto: ArticleDto) : ArticleDto{
        return articleService.edit(articleDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        articleService.deleteById(id)
    }
}