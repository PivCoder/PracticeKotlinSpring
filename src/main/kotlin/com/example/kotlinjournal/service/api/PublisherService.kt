package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Publisher
import java.util.*

interface PublisherService {
    fun add(publisher: Publisher): Publisher
    fun getById(id: Long): Optional<Publisher>
    fun deleteById(id: Long)
    fun edit(publisher: Publisher)
    fun getAll(): List<Publisher>
}