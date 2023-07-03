package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.Organization
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository : JpaRepository<Organization, Long>