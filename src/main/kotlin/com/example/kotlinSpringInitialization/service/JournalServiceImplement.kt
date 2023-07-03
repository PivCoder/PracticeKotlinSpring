package com.example.kotlinSpringInitialization.service

import com.example.kotlinSpringInitialization.model.Journal
import com.example.kotlinSpringInitialization.repositoryes.JournalRepository
import com.example.kotlinSpringInitialization.service.api.JournalService
import org.springframework.stereotype.Service
import java.util.*

@Service
class JournalServiceImplement(private val journalRepository: JournalRepository) : JournalService {
    override fun addJournal(journal: Journal): Journal {
        return journalRepository.save(journal)
    }

    override fun getJournalById(id: Long): Optional<Journal> {
        return journalRepository.findById(id)
    }

    override fun deleteJournalById(id: Long) {
        journalRepository.deleteById(id)
    }

    override fun editJournal(journal: Journal) {
        journalRepository.save(journal)
    }

    override fun getAllJournals(): List<Journal> {
        return journalRepository.findAll()
    }
}