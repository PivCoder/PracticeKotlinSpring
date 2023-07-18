package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.model.enums.UserTypes
import jakarta.validation.constraints.NotBlank

//TODO может задать regex для name, organization, patronymic ?
data class AuthorDto(
    var id: Long?,

    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    @field:NotBlank(message = "Surname must not be empty")
    val surname: String,

    val patronymic: String,
    val pictureRef: String,
    val organization: Organization,
    val city: City,
    val rating: Float,
    val userType: UserTypes
){
    fun toEntity() : Author = Author(
        id = id,
        name = name,
        surname = surname,
        patronymic = patronymic,
        pictureRef = pictureRef,
        organization = organization,
        city = city,
        rating = rating,
        userType = userType
    )
}