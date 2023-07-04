package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Organization
import java.util.*

interface OrganizationService {
    fun add(organization: Organization): Organization
    fun getById(id: Long): Optional<Organization>
    fun deleteById(id: Long)
    fun edit(organization: Organization)
    fun getAll(): List<Organization>
}