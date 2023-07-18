package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.service.api.JournalService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/journal")
class JournalController(private val journalService: JournalService) {
    @GetMapping("/all")
    fun showAllArticles(): List<JournalDto> {
        return journalService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneArticle(@PathVariable id: Long): Optional<JournalDto> {
        return journalService.getById(id)
    }
}