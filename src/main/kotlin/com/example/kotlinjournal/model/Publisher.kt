package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "publisher")
class Publisher(

    val name: String,
    val ISSN: String,

    @JsonBackReference
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    var journals: MutableList<Journal> = mutableListOf(),

    id: Long) : AbstractEntity(id){

    override fun toString(): String {
        return "Publisher(name='$name', ISSN='$ISSN')"
    }


}