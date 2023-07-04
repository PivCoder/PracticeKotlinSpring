package com.example.kotlinjournal.dto

import jakarta.validation.constraints.NotBlank

data class UpdateOrganizationDto(
    @field:NotBlank(message = "Organization must not be empty")
    val name: String
)