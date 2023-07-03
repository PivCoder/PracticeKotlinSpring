package com.example.kotlinSpringInitialization.service.api

import com.example.kotlinSpringInitialization.model.Organization
import java.util.*

interface OrganizationService {
    fun addOrganization(organization: Organization): Organization
    fun getOrganizationById(id: Long): Optional<Organization>
    fun deleteOrganizationById(id: Long)
    fun editOrganization(organization: Organization)
    fun getAllOrganizations(): List<Organization>
}