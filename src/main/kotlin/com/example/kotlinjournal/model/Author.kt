package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "author")
class Author(
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "user_seq")
    @SequenceGenerator(name = "user_seq",
        sequenceName = "project.users_id")
    val id: Long,
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
    val articles: List<Article>) {

    override fun toString(): String {
        return "Author(id=$id, " +
                "name='$name', " +
                "surname='$surname', " +
                "patronymic='$patronymic', " +
                "rating=$rating, " +
                "pictureRef='$pictureRef')"
    }
}