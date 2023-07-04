package com.example.kotlinjournal.dto

import jakarta.validation.constraints.NotBlank

data class CreateCityDto(
    @field:NotBlank(message = "City must not be empty")
    val name: String
)