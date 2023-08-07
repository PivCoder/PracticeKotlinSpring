package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import jakarta.validation.constraints.NotBlank
import java.time.Instant

data class ArticleDto(
    var id: Long,

    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    //TODO подумать как отображать картинку на view слое
    val pictureRef: String,
    val category: Categories,
    val volume: Volume,
    val countPages: Int,
    val countVisits: Int,
    val state: States
) {
    fun toEntity() : Article = Article(
        id = id,
        name = name,
        pictureRef = pictureRef,
        category = category,
        volume = volume,
        state = state,
        countPages = countPages,
        countVisits = countVisits,
        //TODO Нужно в целом переделать DTO. Не совсем понятно как обработать такие поля как время создания и обновления
        createdOn = Instant.now(),
        updatedOn = Instant.now()
    )
}