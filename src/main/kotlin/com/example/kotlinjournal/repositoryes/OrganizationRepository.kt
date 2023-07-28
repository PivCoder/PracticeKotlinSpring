package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.OrganizationDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository : JpaRepository<OrganizationDto, Long>