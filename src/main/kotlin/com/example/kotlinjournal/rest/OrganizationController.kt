package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.service.api.OrganizationService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/organization")
class OrganizationController(private val organizationService: OrganizationService) {
    @GetMapping
    fun showAll(): List<OrganizationDto> {
        return organizationService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): OrganizationDto {
        return organizationService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody organizationDto: OrganizationDto) : OrganizationDto {
        return organizationService.add(organizationDto)
    }

    @PutMapping
    fun update(@RequestBody organizationDto: OrganizationDto) : OrganizationDto {
        return organizationService.edit(organizationDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        organizationService.deleteById(id)
    }
}