package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.model.City
import java.util.*

interface CityService {
    fun add(cityDto: CityDto): City
    fun getById(id: Long): Optional<CityDto>
    fun getByName(name: String): Optional<CityDto>
    fun deleteById(id: Long)
    fun edit(cityDto: CityDto)
    fun getAll(): List<CityDto>
}