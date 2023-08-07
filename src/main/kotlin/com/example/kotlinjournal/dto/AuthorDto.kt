package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.model.Organization
import com.example.kotlinjournal.model.enums.UserTypes
import jakarta.validation.constraints.NotBlank
import java.time.Instant

data class AuthorDto(
    var id: Long,

    @field:NotBlank(message = "Name must not be empty")
    val name: String,

    @field:NotBlank(message = "Surname must not be empty")
    val surname: String,

    val patronymic: String,
    val pictureRef: String,
    val organization: Organization,
    val city: City,
    val rating: Float,
    val userType: UserTypes,
    var articles: MutableList<Article>
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
        userType = userType,
        createdOn = Instant.now(),
        updatedOn = Instant.now()
    )
}