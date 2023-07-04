package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.Journal
import com.example.kotlinjournal.repositoryes.JournalRepository
import com.example.kotlinjournal.service.api.JournalService
import org.springframework.stereotype.Service
import java.util.*

@Service
class JournalServiceImpl(private val journalRepository: JournalRepository) : JournalService {
    override fun add(journal: Journal): Journal {
        return journalRepository.save(journal)
    }

    override fun getById(id: Long): Optional<Journal> {
        return journalRepository.findById(id)
    }

    override fun deleteById(id: Long) {
        journalRepository.deleteById(id)
    }

    override fun edit(journal: Journal) {
        journalRepository.save(journal)
    }

    override fun getAll(): List<Journal> {
        return journalRepository.findAll()
    }
}