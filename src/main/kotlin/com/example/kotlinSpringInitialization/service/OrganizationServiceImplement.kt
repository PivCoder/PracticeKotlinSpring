package com.example.kotlinSpringInitialization.service

import com.example.kotlinSpringInitialization.model.Organization
import com.example.kotlinSpringInitialization.repositoryes.OrganizationRepository
import com.example.kotlinSpringInitialization.service.api.OrganizationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImplement(private val organizationRepository: OrganizationRepository) : OrganizationService{
    override fun addOrganization(organization: Organization): Organization {
        return organizationRepository.save(organization)
    }

    override fun getOrganizationById(id: Long): Optional<Organization> {
        return organizationRepository.findById(id)
    }

    override fun deleteOrganizationById(id: Long) {
        organizationRepository.deleteById(id)
    }

    override fun editOrganization(organization: Organization) {
        organizationRepository.save(organization)
    }

    override fun getAllOrganizations(): List<Organization> {
        return organizationRepository.findAll()
    }
}