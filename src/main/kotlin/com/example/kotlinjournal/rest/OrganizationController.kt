package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.service.api.OrganizationService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/organization")
class OrganizationController(private val organizationService: OrganizationService) {
    @GetMapping("/all")
    fun showAllArticles(): List<OrganizationDto> {
        return organizationService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneArticle(@PathVariable id: Long): Optional<OrganizationDto> {
        return organizationService.getById(id)
    }

    @PostMapping("/create")
    fun createArticle(@RequestBody organizationDto: OrganizationDto) : Organization {
        return organizationService.add(organizationDto);
    }
}