package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Author, Long>