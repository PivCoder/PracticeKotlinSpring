package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Journal
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateVolumeDto(
    @field:NotBlank(message = "Volume must not be empty")
    val name: String,

    @field:NotNull
    val journal: Journal,

    @field:NotNull
    val articles: List<Article>
)