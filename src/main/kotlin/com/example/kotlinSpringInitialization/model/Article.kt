package com.example.kotlinSpringInitialization.model

import com.example.kotlinSpringInitialization.model.enums.Categories
import com.example.kotlinSpringInitialization.model.enums.States
import jakarta.persistence.*
//TODO попробоовать id вынести в абстрактную сущность, generation type Auto
@Entity
@Table(schema = "project", name = "article")
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "article_seq")
    @SequenceGenerator(name = "article_seq",
        sequenceName = "project.articles_id")
    val id: Long,
    val name: String,
    val countPages: Int,
    val countVisits: Int,
    val pictureRef: String,
    val category: Categories,
    val state: States,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "volume_id")
    val volume: Volume,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "article_author",
        joinColumns = [JoinColumn(name = "articles_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: List<Author>) {

    override fun toString(): String {
        return "Article(id=$id, " +
                "name='$name', " +
                "countPages=$countPages, " +
                "countVisits=$countVisits, " +
                "pictureRef='$pictureRef', " +
                "category=$category, " +
                "state=$state)"
    }
}