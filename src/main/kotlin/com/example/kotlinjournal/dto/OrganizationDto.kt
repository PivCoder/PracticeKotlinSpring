package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Organization
import jakarta.validation.constraints.NotBlank

data class OrganizationDto(
    var id: Long?,

    @field:NotBlank(message = "Organization must not be empty")
    val name: String
){
    fun toEntity() : Organization = Organization(
        id = id,
        name = name
    )
}