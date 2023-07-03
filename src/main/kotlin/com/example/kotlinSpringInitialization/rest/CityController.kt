package com.example.kotlinSpringInitialization.rest

import com.example.kotlinSpringInitialization.model.City
import com.example.kotlinSpringInitialization.service.CityServiceImplement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cities")
class CityController(private val cityServiceImplement: CityServiceImplement) {

    @GetMapping("/all")
    fun showAllCities(): List<City>{
        return cityServiceImplement.getAllCities()
    }
}