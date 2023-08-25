package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.PublisherDto
import java.util.*

interface PublisherService {
    fun add(publisherDto: PublisherDto): PublisherDto
    fun getById(id: Long): PublisherDto
    fun deleteById(id: Long)
    fun edit(publisherDto: PublisherDto): PublisherDto
    fun getAll(): List<PublisherDto>
}