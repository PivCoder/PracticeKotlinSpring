package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.CityDto
import java.util.*

interface CityService {
    fun add(cityDto: CityDto): CityDto
    fun getById(id: Long): CityDto
    fun getByName(name: String): CityDto
    fun deleteById(id: Long)
    fun edit(cityDto: CityDto): CityDto
    fun getAll(): List<CityDto>
}