package com.example.kotlinSpringInitialization.service.api

import com.example.kotlinSpringInitialization.model.Journal
import java.util.*

interface JournalService {
    fun addJournal(journal: Journal): Journal
    fun getJournalById(id: Long): Optional<Journal>
    fun deleteJournalById(id: Long)
    fun editJournal(journal: Journal)
    fun getAllJournals(): List<Journal>
}