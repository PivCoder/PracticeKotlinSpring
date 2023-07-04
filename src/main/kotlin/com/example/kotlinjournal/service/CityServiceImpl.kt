package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.repositoryes.CityRepository
import com.example.kotlinjournal.service.api.CityService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CityServiceImpl(private val cityRepository: CityRepository) : CityService{
    override fun add(city: City): City {
        return cityRepository.save(city)
    }

    override fun getById(id: Long): Optional<City> {
        return cityRepository.findById(id)
    }

    override fun getByName(name: String): Optional<City> {
        return cityRepository.findByName(name)
    }

    override fun deleteById(id: Long) {
        cityRepository.deleteById(id)
    }

    override fun edit(city: City) {
        cityRepository.save(city)
    }

    override fun getAll(): List<City> {
        return cityRepository.findAll()
    }
}