package com.example.kotlinjournal.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "journal")
class Journal(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "journal_seq")
    @SequenceGenerator(name = "journal_seq",
        sequenceName = "project.journals_id")
    val id: Long,
    val name: String,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "publisher_id")
    val publisher: Publisher,

    @JsonBackReference
    @OneToMany(mappedBy = "journal", fetch = FetchType.LAZY)
    val volumes: List<Volume>) {

    override fun toString(): String {
        return "Journal(id=$id, name='$name')"
    }


}