package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.repositoryes.OrganizationRepository
import com.example.kotlinjournal.service.api.OrganizationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImpl(private val organizationRepository: OrganizationRepository) : OrganizationService{
    override fun add(organizationDto: OrganizationDto): Organization {
        return organizationRepository.save(organizationDto.toEntity())
    }

    override fun getById(id: Long): Optional<OrganizationDto> {
        return organizationRepository.findById(id).map {
            OrganizationDto(
                it.id,
                it.name
            )
        }
    }

    override fun deleteById(id: Long) {
        organizationRepository.deleteById(id)
    }

    override fun edit(organizationDto: OrganizationDto) {
        organizationRepository.save(organizationDto.toEntity())
    }

    override fun getAll(): List<OrganizationDto> {
        return organizationRepository.findAll().map {
            OrganizationDto(
                it.id,
                it.name
            )
        }
    }
}