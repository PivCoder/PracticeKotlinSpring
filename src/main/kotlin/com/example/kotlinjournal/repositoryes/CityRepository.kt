package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.model.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CityRepository : JpaRepository<CityDto, Long>{
    fun findByName(name: String): Optional<City>
}