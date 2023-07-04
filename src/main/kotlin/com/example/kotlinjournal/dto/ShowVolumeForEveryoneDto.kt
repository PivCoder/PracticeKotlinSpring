package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Journal

data class ShowVolumeForEveryoneDto(
    val name: String,
    val journal: Journal,
    val articles: List<Article>,
)