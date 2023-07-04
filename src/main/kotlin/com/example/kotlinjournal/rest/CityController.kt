package com.example.kotlinjournal.rest

import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.service.CityServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/city")
class CityController(private val cityServiceImpl: CityServiceImpl) {

    @GetMapping("/all")
    fun showAllCities(): List<City>{
        return cityServiceImpl.getAllCities()
    }

    @GetMapping("/{id}")
    fun showOneCity(@PathVariable id: Long): Optional<City> {
        return cityServiceImpl.getCityById(id)
    }
}