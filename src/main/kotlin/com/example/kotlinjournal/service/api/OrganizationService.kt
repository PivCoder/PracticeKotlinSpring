package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.OrganizationDto
import java.util.*

interface OrganizationService {
    fun add(organizationDto: OrganizationDto): OrganizationDto
    fun getById(id: Long): OrganizationDto
    fun deleteById(id: Long)
    fun edit(organizationDto: OrganizationDto): OrganizationDto
    fun getAll(): List<OrganizationDto>
}