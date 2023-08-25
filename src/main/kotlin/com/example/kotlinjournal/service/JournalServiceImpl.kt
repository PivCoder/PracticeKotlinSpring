package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.repositoryes.JournalRepository
import com.example.kotlinjournal.service.api.JournalService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class JournalServiceImpl(private val journalRepository: JournalRepository) : JournalService {
    override fun add(journalDto: JournalDto): JournalDto {
        journalRepository.save(journalDto.toEntity())
        return journalDto
    }

    override fun getById(id: Long): JournalDto {
         val journal = journalRepository.findById(id).map {
            JournalDto(
                it.id,
                it.name,
                it.publisher
            )
        }.orElseThrow {
             throw ElementNotFoundException()
        }

        return journal
    }

    override fun deleteById(id: Long) {
        journalRepository.deleteById(id)
    }

    override fun edit(journalDto: JournalDto): JournalDto {
        journalRepository.findById(journalDto.id)
            .orElseThrow{
                throw ElementNotFoundException()
            }

        journalRepository.save(journalDto.toEntity())
        return journalDto
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