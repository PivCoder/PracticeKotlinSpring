package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.service.api.JournalService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/journal")
class JournalController(private val journalService: JournalService) {
    @GetMapping
    fun showAll(): List<JournalDto> {
        return journalService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): JournalDto {
        return journalService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody journalDto: JournalDto) : JournalDto {
        return journalService.add(journalDto);
    }

    @PutMapping
    fun update(@RequestBody journalDto: JournalDto) : JournalDto {
        return journalService.edit(journalDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        journalService.deleteById(id)
    }
}