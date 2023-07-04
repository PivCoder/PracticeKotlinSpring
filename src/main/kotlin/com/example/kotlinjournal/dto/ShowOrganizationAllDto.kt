package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author

data class ShowOrganizationAllDto(
    val id: Long,
    val name: String,
    val authors: List<Author>
)