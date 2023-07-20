package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Publisher
import jakarta.validation.constraints.NotBlank

//TODO добавить regex для ISSN
data class PublisherDto(
    var id: Long,

    @field:NotBlank(message = "Publisher must not be empty")
    val name: String,

    val ISSN: String,
){
    fun toEntity() : Publisher = Publisher(
        id = id,
        name = name,
        ISSN = ISSN
    )
}