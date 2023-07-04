package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.model.Organization

data class ShowAuthorAllDto(
    val id: Long,
    val name: String,
    val surname: String,
    val patronymic: String,
    val rating: Float,
    val pictureRef: String,
    val organization: Organization,
    val city: City,
    val articles: List<Article>
)