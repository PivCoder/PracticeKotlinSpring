package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.Journal
import org.springframework.data.jpa.repository.JpaRepository

interface JournalRepository : JpaRepository<Journal, Long>