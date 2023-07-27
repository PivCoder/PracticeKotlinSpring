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
    fun showAll(): List<PublisherDto> {
        return publisherService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<PublisherDto> {
        return publisherService.getById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody publisherDto: PublisherDto) : Publisher {
        return publisherService.add(publisherDto);
    }

    @PutMapping("/update")
    fun update(@RequestBody publisherDto: PublisherDto) : Publisher {
        return publisherService.edit(publisherDto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long){
        publisherService.deleteById(id)
    }
}