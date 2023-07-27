package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.model.Journal
import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.service.api.OrganizationService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/organization")
class OrganizationController(private val organizationService: OrganizationService) {
    @GetMapping("/all")
    fun showAll(): List<OrganizationDto> {
        return organizationService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<OrganizationDto> {
        return organizationService.getById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody organizationDto: OrganizationDto) : Organization {
        return organizationService.add(organizationDto);
    }

    @PutMapping("/update")
    fun update(@RequestBody organizationDto: OrganizationDto) : Organization {
        return organizationService.edit(organizationDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        organizationService.deleteById(id)
    }
}