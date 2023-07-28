package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.JournalDto
import org.springframework.data.jpa.repository.JpaRepository

interface JournalRepository : JpaRepository<JournalDto, Long>