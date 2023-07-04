package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "city")
class City(

    val name: String,

    @JsonBackReference
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    val authors: List<Author>,

    id: Long) : AbstractEntity(id) {

    override fun toString(): String {
        return "City(name='$name')"
    }
}