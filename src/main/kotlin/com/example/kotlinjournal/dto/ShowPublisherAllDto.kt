package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Journal

data class ShowPublisherAllDto(
    val id: Long,
    val name: String,
    val ISSN: String,
    val journals: List<Journal>
)