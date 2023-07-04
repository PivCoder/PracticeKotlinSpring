package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "author")
class Author(
    val name: String,
    val surname: String,
    val patronymic: String,
    val rating: Float,
    val pictureRef: String,

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
    val articles: List<Article>,

    id: Long) : AbstractEntity(id){

    override fun toString(): String {
        return "Author(name='$name', " +
                "surname='$surname', " +
                "patronymic='$patronymic', " +
                "rating=$rating, " +
                "pictureRef='$pictureRef')"
    }
}