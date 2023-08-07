package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(schema = "project", name = "publisher")
class Publisher(

    val name: String,
    val ISSN: String,

    @JsonBackReference
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    var journals: MutableList<Journal> = mutableListOf(),

    id: Long,
    createdOn: Instant,
    updatedOn: Instant
) : AbstractEntity(id, createdOn, updatedOn){

    override fun toString(): String {
        return "Publisher(name='$name', ISSN='$ISSN')"
    }


}