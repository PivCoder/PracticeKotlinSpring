package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.repositoryes.CityRepository
import com.example.kotlinjournal.service.api.CityService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CityServiceImplement(private val cityRepository: CityRepository) : CityService{
    override fun addCity(city: City): City {
        return cityRepository.save(city)
    }

    override fun getCityById(id: Long): Optional<City> {
        return cityRepository.findById(id)
    }

    override fun deleteCityById(id: Long) {
        cityRepository.deleteById(id)
    }

    override fun editCity(city: City) {
        cityRepository.save(city)
    }

    override fun getAllCities(): List<City> {
        return cityRepository.findAll()
    }
}