package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(schema = "project", name = "journal")
class Journal(

    val name: String,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "publisher_id")
    val publisher: Publisher,

    @JsonBackReference
    @OneToMany(mappedBy = "journal", fetch = FetchType.LAZY)
    var volumes: MutableList<Volume> = mutableListOf(),

    id: Long,
    createdOn: Instant,
    updatedOn: Instant
) : AbstractEntity(id, createdOn, updatedOn) {

    override fun toString(): String {
        return "Journal(name='$name')"
    }


}