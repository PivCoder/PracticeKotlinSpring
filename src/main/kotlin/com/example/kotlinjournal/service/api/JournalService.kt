package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.JournalDto
import java.util.*

interface JournalService {
    fun add(journalDto: JournalDto): JournalDto
    fun getById(id: Long): Optional<JournalDto>
    fun deleteById(id: Long)
    fun edit(journalDto: JournalDto): JournalDto
    fun getAll(): List<JournalDto>
}