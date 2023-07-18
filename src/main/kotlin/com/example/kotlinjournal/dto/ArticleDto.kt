package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import jakarta.validation.constraints.NotBlank

data class ArticleDto(
    var id: Long?,

    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    //TODO подумать как отображать картинку на view слое
    val pictureRef: String,
    val category: Categories,
    val volume: Volume,
    val countPage: Int,
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
        countPages = countPage,
        countVisits = countVisits)
}