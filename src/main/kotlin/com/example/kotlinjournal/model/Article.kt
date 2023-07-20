package com.example.kotlinjournal.model

import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "article")
class Article(
    val name: String,
    val countPages: Int,
    val countVisits: Int,
    val pictureRef: String,
    @Enumerated(EnumType.STRING)
    val category: Categories,
    @Enumerated(EnumType.STRING)
    val state: States,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "volume_id")
    val volume: Volume,

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "article_author",
        joinColumns = [JoinColumn(name = "articles_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    var authors: MutableList<Author> = mutableListOf(),

    id: Long) : AbstractEntity(id) {

    override fun toString(): String {
        return "Article(name='$name', " +
                "countPages=$countPages, " +
                "countVisits=$countVisits, " +
                "pictureRef='$pictureRef', " +
                "category=$category, " +
                "state=$state)"
    }
}