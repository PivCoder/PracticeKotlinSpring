package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.service.api.PublisherService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/publisher")
class PublisherController(private val publisherService: PublisherService) {
    @GetMapping
    fun showAll(): List<PublisherDto> {
        return publisherService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): PublisherDto {
        return publisherService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody publisherDto: PublisherDto) : PublisherDto {
        return publisherService.add(publisherDto)
    }

    @PutMapping
    fun update(@RequestBody publisherDto: PublisherDto) : PublisherDto {
        return publisherService.edit(publisherDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        publisherService.deleteById(id)
    }
}