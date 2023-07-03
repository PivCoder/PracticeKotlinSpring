package com.example.kotlinjournal.rest

import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.service.CityServiceImplement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/city")
class CityController(private val cityServiceImplement: CityServiceImplement) {

    @GetMapping("/all")
    fun showAllCities(): List<City>{
        return cityServiceImplement.getAllCities()
    }
}