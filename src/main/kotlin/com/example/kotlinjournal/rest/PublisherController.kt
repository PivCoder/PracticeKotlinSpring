package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.service.api.PublisherService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/publisher")
class PublisherController(private val publisherService: PublisherService) {
    @GetMapping("/all")
    fun showAllArticles(): List<PublisherDto> {
        return publisherService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneArticle(@PathVariable id: Long): Optional<PublisherDto> {
        return publisherService.getById(id)
    }

    @PostMapping("/create")
    fun createArticle(@RequestBody publisherDto: PublisherDto) : Publisher {
        return publisherService.add(publisherDto);
    }
}