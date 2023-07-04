package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.model.Volume
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateJournalDto(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    @field:NotNull
    val publisher: Publisher,

    @field:NotNull
    val volumes: List<Volume>
)