package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.AuthorDto
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<AuthorDto, Long>