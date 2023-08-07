package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.City
import jakarta.validation.constraints.NotBlank
import java.time.Instant

data class CityDto(
    var id: Long,

    @field:NotBlank(message = "City must not be empty")
    val name: String
) {
    fun toEntity() : City = City(
        id = id,
        name = name,
        createdOn = Instant.now(),
        updatedOn = Instant.now())
}