package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States

data class ShowArticleAllDto(
    val id: Long,
    val name: String,
    val countPages: Int,
    val countVisits: Int,
    val pictureRef: String,
    val category: Categories,
    val volume: Volume,
    val authors: List<Author>,
    val state: States
)