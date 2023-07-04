package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Journal
import java.util.*

interface JournalService {
    fun add(journal: Journal): Journal
    fun getById(id: Long): Optional<Journal>
    fun deleteById(id: Long)
    fun edit(journal: Journal)
    fun getAll(): List<Journal>
}