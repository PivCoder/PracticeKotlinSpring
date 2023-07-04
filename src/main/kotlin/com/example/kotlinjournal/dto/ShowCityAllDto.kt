package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author

data class ShowCityAllDto(
    val id: Long,
    val name: String,
    val authors: List<Author>
)