package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.CityDto
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
    fun showOneCity(@PathVariable id: Long): CityDto {
        return cityService.getById(id)
    }

    @GetMapping("name/{name}")
    fun showByName(@PathVariable name: String): CityDto {
        return cityService.getByName(name)
    }

    @PostMapping
    fun create(@RequestBody cityDto: CityDto): CityDto {
        return cityService.add(cityDto);
    }

    @PutMapping
    fun update(@RequestBody cityDto: CityDto): CityDto {
        return cityService.edit(cityDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        cityService.deleteById(id)
    }
}