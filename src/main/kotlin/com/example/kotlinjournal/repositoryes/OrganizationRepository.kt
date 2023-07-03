package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.Organization
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository : JpaRepository<Organization, Long>