package com.example.kotlinjournal.dto

import jakarta.validation.constraints.NotBlank

//TODO добавить regex для ISSN
data class UpdatePublisherDto(
    @field:NotBlank(message = "Publisher must not be empty")
    val name: String,

    val ISSN: String,
)