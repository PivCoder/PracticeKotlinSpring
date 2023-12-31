package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.OrganizationDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.repositoryes.OrganizationRepository
import com.example.kotlinjournal.service.api.OrganizationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImpl(private val organizationRepository: OrganizationRepository) : OrganizationService{
    override fun add(organizationDto: OrganizationDto): OrganizationDto {
        organizationRepository.save(organizationDto.toEntity())
        return organizationDto
    }

    override fun getById(id: Long): OrganizationDto {
        val organization = organizationRepository.findById(id).map {
            OrganizationDto(
                it.id,
                it.name
            )
        }.orElseThrow{
            throw ElementNotFoundException()
        }

        return organization
    }

    override fun deleteById(id: Long) {
        organizationRepository.deleteById(id)
    }

    override fun edit(organizationDto: OrganizationDto): OrganizationDto {
        organizationRepository.findById(organizationDto.id)
            .orElseThrow{
                throw ElementNotFoundException()
            }

        organizationRepository.save(organizationDto.toEntity())
        return organizationDto
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