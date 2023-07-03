package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Publisher
import java.util.*

interface PublisherService {
    fun addPublisher(publisher: Publisher): Publisher
    fun getPublisherById(id: Long): Optional<Publisher>
    fun deletePublisherById(id: Long)
    fun editPublisher(publisher: Publisher)
    fun getAllPublishers(): List<Publisher>
}