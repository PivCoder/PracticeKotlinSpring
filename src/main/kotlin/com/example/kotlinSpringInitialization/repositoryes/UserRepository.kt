package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Author, Long>