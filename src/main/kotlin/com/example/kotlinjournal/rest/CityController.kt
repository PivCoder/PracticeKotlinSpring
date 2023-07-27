package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.service.api.CityService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/city")
class CityController(private val cityService: CityService) {

    @GetMapping
    fun showAll(): List<CityDto> {
        return cityService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneCity(@PathVariable id: Long): Optional<CityDto> {
        return cityService.getById(id)
    }

    @GetMapping("/name/{name}")
    fun showByName(@PathVariable name: String): Optional<CityDto> {
        return cityService.getByName(name)
    }

    @PostMapping
    fun create(@RequestBody cityDto: CityDto) : City {
        return cityService.add(cityDto);
    }
}