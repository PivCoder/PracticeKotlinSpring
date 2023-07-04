package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

class CreateArticleDto(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    //TODO подумать как отображать картинку на view слое
    @field:NotNull
    val pictureRef: String,

    @field:NotNull
    val category: Categories,

    @field:NotNull
    val authors: List<Author>,
)