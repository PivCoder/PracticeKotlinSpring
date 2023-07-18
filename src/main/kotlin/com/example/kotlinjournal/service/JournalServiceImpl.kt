package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.model.Journal
import com.example.kotlinjournal.repositoryes.JournalRepository
import com.example.kotlinjournal.service.api.JournalService
import org.springframework.stereotype.Service
import java.util.*

@Service
class JournalServiceImpl(private val journalRepository: JournalRepository) : JournalService {
    override fun add(journalDto: JournalDto): Journal {
        return journalRepository.save(journalDto.toEntity())
    }

    override fun getById(id: Long): Optional<JournalDto> {
        return journalRepository.findById(id).map {
            JournalDto(
                it.id,
                it.name,
                it.publisher
            )
        }
    }

    override fun deleteById(id: Long) {
        journalRepository.deleteById(id)
    }

    override fun edit(journalDto: JournalDto) {
        journalRepository.save(journalDto.toEntity())
    }

    override fun getAll(): List<JournalDto> {
        return journalRepository.findAll().map {
            JournalDto(
                it.id,
                it.name,
                it.publisher
            )
        }
    }
}