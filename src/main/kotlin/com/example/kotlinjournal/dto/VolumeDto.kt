package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Journal
import com.example.kotlinjournal.model.Volume
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.Instant

data class VolumeDto(
    var id: Long,

    @field:NotBlank(message = "Volume must not be empty")
    val name: String,

    @field:NotNull
    val journal: Journal
){
    fun toEntity() : Volume = Volume(
        id = id,
        name = name,
        journal = journal,
        createdOn = Instant.now(),
        updatedOn = Instant.now()
    )
}