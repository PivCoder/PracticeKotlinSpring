package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(schema = "project", name = "organization")
class Organization(

    val name: String,

    @JsonBackReference
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    var authors: MutableList<Author> = mutableListOf(),

    id: Long,
    createdOn: Instant,
    updatedOn: Instant
) : AbstractEntity(id, createdOn, updatedOn) {

    override fun toString(): String {
        return "Organization(name='$name')"
    }
}