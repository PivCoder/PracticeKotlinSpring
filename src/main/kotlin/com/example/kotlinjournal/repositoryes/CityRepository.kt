package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<City, Long>