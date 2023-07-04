package com.example.kotlinjournal.dto

import jakarta.validation.constraints.NotBlank

data class UpdateCityDto(
    @field:NotBlank(message = "City must not be empty")
    val name: String
)