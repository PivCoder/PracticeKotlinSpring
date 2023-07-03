package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>