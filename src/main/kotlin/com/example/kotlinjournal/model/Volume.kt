package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(schema = "project", name = "volume")
class Volume(

    val name: String,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "journal_id")
    val journal: Journal,

    @JsonBackReference
    @OneToMany(mappedBy = "volume", fetch = FetchType.LAZY)
    var articles: MutableList<Article> = mutableListOf(),

    id: Long,
    createdOn: Instant,
    updatedOn: Instant
) : AbstractEntity(id, createdOn, updatedOn) {

    override fun toString(): String {
        return "Volume(name='$name')"
    }
}