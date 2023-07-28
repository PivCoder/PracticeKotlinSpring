package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.PublisherDto
import org.springframework.data.jpa.repository.JpaRepository

interface PublisherRepository : JpaRepository<PublisherDto, Long>