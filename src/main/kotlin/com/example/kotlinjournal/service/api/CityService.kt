package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.City
import java.util.*

interface CityService {
    fun addCity(city: City): City
    fun getCityById(id: Long): Optional<City>
    fun deleteCityById(id: Long)
    fun editCity(city: City)
    fun getAllCities(): List<City>
}