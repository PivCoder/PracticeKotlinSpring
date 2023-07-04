package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.repositoryes.OrganizationRepository
import com.example.kotlinjournal.service.api.OrganizationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImpl(private val organizationRepository: OrganizationRepository) : OrganizationService{
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