package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.service.CityServiceImpl
import com.example.kotlinjournal.service.api.CityService
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

//TODO Inject interface а не serviceImpl PathParam посмотреть ApplicationContext почитать подробнее
//TODO почитать за разницу между @REstController and @Controller

@RestController
@RequestMapping("/city")
class CityController(private val cityService: CityService) {

    @GetMapping("/all")
    fun showAllCities(): List<CityDto> {
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
}