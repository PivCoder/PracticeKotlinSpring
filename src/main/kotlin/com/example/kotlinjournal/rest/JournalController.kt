package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.model.Journal
import com.example.kotlinjournal.service.api.JournalService
import org.springframework.web.bind.annotation.*
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

    @PostMapping("/create")
    fun createArticle(@RequestBody journalDto: JournalDto) : Journal {
        return journalService.add(journalDto);
    }
}