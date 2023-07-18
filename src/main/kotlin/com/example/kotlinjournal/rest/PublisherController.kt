package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.service.api.PublisherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}