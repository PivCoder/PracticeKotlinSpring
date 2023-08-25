package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.repositoryes.PublisherRepository
import com.example.kotlinjournal.service.api.PublisherService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PublisherServiceImpl(private val publisherRepository: PublisherRepository) : PublisherService {
    override fun add(publisherDto: PublisherDto): PublisherDto {
        publisherRepository.save(publisherDto.toEntity())
        return publisherDto
    }

    override fun getById(id: Long): PublisherDto {
        val publisher = publisherRepository.findById(id).map {
            PublisherDto(
                it.id,
                it.name,
                it.ISSN
            )
        }.orElseThrow{
            throw ElementNotFoundException()
        }

        return publisher
    }

    override fun deleteById(id: Long) {
        publisherRepository.deleteById(id)
    }

    override fun edit(publisherDto: PublisherDto): PublisherDto {
        publisherRepository.findById(publisherDto.id)
            .orElseThrow{
                throw ElementNotFoundException()
            }

        publisherRepository.save(publisherDto.toEntity())
        return publisherDto
    }

    override fun getAll(): List<PublisherDto> {
        return publisherRepository.findAll().map {
            PublisherDto(
                it.id,
                it.name,
                it.ISSN
            )
        }
    }
}