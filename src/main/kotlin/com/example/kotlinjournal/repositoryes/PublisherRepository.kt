package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.Publisher
import org.springframework.data.jpa.repository.JpaRepository

interface PublisherRepository : JpaRepository<Publisher, Long>