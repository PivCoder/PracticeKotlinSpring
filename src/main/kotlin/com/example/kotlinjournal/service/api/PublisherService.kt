package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.model.Publisher
import java.util.*

interface PublisherService {
    fun add(publisherDto: PublisherDto): Publisher
    fun getById(id: Long): Optional<PublisherDto>
    fun deleteById(id: Long)
    fun edit(publisherDto: PublisherDto): Publisher
    fun getAll(): List<PublisherDto>
}