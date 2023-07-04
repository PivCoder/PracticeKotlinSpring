package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class UpdateArticleDto(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    @field:NotNull
    val pictureRef: String,

    @field:NotNull
    val category: Categories,

    @field:NotNull
    val state: States,

    @field:NotNull
    val authors: List<Author>,
)