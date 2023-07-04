package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.enums.Categories

data class ShowArticleForEveryoneDto(
    val name: String,
    val countPages: Int,
    val countVisits: Int,
    val pictureRef: String,
    val category: Categories,
    val authors: List<Author>,
)