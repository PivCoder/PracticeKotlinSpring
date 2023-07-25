package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.service.api.CityService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/city")
class CityController(private val cityService: CityService) {

    @GetMapping("get/all")
    fun showAll(): List<CityDto> {
        return cityService.getAll()
    }

    @GetMapping("get/{id}")
    fun showOneCity(@PathVariable id: Long): Optional<CityDto> {
        return cityService.getById(id)
    }

    @GetMapping("get/name/{name}")
    fun showByName(@PathVariable name: String): Optional<CityDto> {
        return cityService.getByName(name)
    }

    @PostMapping("/create")
    fun create(@RequestBody cityDto: CityDto) : City {
        return cityService.add(cityDto);
    }
}