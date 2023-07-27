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
    fun showAll(): List<JournalDto> {
        return journalService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<JournalDto> {
        return journalService.getById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody journalDto: JournalDto) : Journal {
        return journalService.add(journalDto);
    }

    @PutMapping("/update")
    fun update(@RequestBody journalDto: JournalDto) : Journal {
        return journalService.edit(journalDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        journalService.deleteById(id)
    }
}