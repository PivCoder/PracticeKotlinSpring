package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.Publisher
import org.springframework.data.jpa.repository.JpaRepository

interface PublisherRepository : JpaRepository<Publisher, Long>