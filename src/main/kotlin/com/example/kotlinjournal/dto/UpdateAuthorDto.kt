package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.model.Organization
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateAuthorDto(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    @field:NotBlank(message = "Surname must not be empty")
    val surname: String,

    val patronymic: String,

    @field:NotNull
    val pictureRef: String,

    val organization: Organization,

    val city: City,

    val articles: List<Article>
)