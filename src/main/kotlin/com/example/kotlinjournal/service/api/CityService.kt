package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.City
import java.util.*

interface CityService {
    fun add(city: City): City
    fun getById(id: Long): Optional<City>
    fun getByName(name: String): Optional<City>
    fun deleteById(id: Long)
    fun edit(city: City)
    fun getAll(): List<City>
}