package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<City, Long>