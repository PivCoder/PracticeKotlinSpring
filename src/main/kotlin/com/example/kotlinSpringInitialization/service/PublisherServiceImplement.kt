package com.example.kotlinSpringInitialization.service

import com.example.kotlinSpringInitialization.model.Publisher
import com.example.kotlinSpringInitialization.repositoryes.PublisherRepository
import com.example.kotlinSpringInitialization.service.api.PublisherService
import org.springframework.stereotype.Service
import java.util.*

@Service
class PublisherServiceImplement(private val publisherRepository: PublisherRepository) : PublisherService {
    override fun addPublisher(publisher: Publisher): Publisher {
        return publisherRepository.save(publisher)
    }

    override fun getPublisherById(id: Long): Optional<Publisher> {
        return publisherRepository.findById(id)
    }

    override fun deletePublisherById(id: Long) {
        publisherRepository.deleteById(id)
    }

    override fun editPublisher(publisher: Publisher) {
        publisherRepository.save(publisher)
    }

    override fun getAllPublishers(): List<Publisher> {
        return publisherRepository.findAll()
    }
}