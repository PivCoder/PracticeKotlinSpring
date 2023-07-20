package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.model.Journal
import java.util.*

interface JournalService {
    fun add(journalDto: JournalDto): Journal
    fun getById(id: Long): Optional<JournalDto>
    fun deleteById(id: Long)
    fun edit(journalDto: JournalDto): Journal
    fun getAll(): List<JournalDto>
}