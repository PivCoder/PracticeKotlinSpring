package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.Journal
import org.springframework.data.jpa.repository.JpaRepository

interface JournalRepository : JpaRepository<Journal, Long>