package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.service.api.AuthorService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/author")
class AuthorController(private val authorService: AuthorService) {
    @GetMapping
    fun showAll(): List<AuthorDto> {
        return authorService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<AuthorDto> {
        return authorService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody authorDto: AuthorDto) : AuthorDto {
        return authorService.add(authorDto);
    }

    @PutMapping
    fun update(@RequestBody authorDto: AuthorDto) : AuthorDto {
        return authorService.edit(authorDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        authorService.deleteById(id)
    }
}