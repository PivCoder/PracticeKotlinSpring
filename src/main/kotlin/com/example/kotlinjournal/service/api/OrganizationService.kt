package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Organization
import java.util.*

interface OrganizationService {
    fun addOrganization(organization: Organization): Organization
    fun getOrganizationById(id: Long): Optional<Organization>
    fun deleteOrganizationById(id: Long)
    fun editOrganization(organization: Organization)
    fun getAllOrganizations(): List<Organization>
}