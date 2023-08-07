package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.service.util.InputDataFormatUtil.Companion.ISSN_FORMAT
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.time.Instant

data class PublisherDto(
    var id: Long,

    @field:NotBlank(message = "Publisher must not be empty")
    val name: String,

    @Pattern(regexp = ISSN_FORMAT, message = "Invalid ISSN format (format: XXXX-XXX)")
    val ISSN: String,
){
    fun toEntity() : Publisher = Publisher(
        id = id,
        name = name,
        ISSN = ISSN,
        createdOn = Instant.now(),
        updatedOn = Instant.now()
    )
}