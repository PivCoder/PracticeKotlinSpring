package com.example.kotlinjournal.model

import com.example.kotlinjournal.model.enums.UserTypes
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(schema = "project", name = "author")
class Author(
    val name: String,
    val surname: String,
    val patronymic: String,
    val rating: Float,
    val pictureRef: String,
    @Enumerated(EnumType.STRING)
    val userType: UserTypes,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "organization_id")
    val organization: Organization,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "city_id")
    val city: City,

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "authors")
    var articles: MutableList<Article> = mutableListOf(),

    id: Long,
    createdOn: Instant,
    updatedOn: Instant
) : AbstractEntity(id, createdOn, updatedOn){

    override fun toString(): String {
        return "Author(name='$name', " +
                "surname='$surname', " +
                "patronymic='$patronymic', " +
                "rating='$rating', " +
                "pictureRef='$pictureRef', " +
                "userType = '$userType')"
    }
}