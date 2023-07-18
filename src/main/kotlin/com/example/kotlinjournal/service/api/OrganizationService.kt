package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.model.Organization
import java.util.*

interface OrganizationService {
    fun add(organizationDto: OrganizationDto): Organization
    fun getById(id: Long): Optional<OrganizationDto>
    fun deleteById(id: Long)
    fun edit(organizationDto: OrganizationDto)
    fun getAll(): List<OrganizationDto>
}