package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Journal

data class ShowVolumeAllDto(
    val id: Long,
    val name: String,
    val journal: Journal,
    val articles: List<Article>
)