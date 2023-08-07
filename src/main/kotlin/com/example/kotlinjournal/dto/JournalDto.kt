package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Journal
import com.example.kotlinjournal.model.Publisher
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.Instant

data class JournalDto(
    var id: Long,

    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    @field:NotNull
    val publisher: Publisher
){
    fun toEntity(): Journal = Journal(
        id = id,
        name = name,
        publisher = publisher,
        createdOn = Instant.now(),
        updatedOn = Instant.now()
    )
}