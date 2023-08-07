package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(schema = "project", name = "city")
class City(

    val name: String,

    @JsonBackReference
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    var authors: MutableList<Author> = mutableListOf(),

    id: Long,
    createdOn: Instant,
    updatedOn: Instant
) : AbstractEntity(id, createdOn, updatedOn) {

    override fun toString(): String {
        return "City(name='$name')"
    }
}