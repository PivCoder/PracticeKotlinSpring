package com.example.kotlinSpringInitialization.model

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "publisher_id")
    val publisher: Publisher,

    @OneToMany(mappedBy = "journal", fetch = FetchType.LAZY)
    val volumes: List<Volume>) {

    override fun toString(): String {
        return "Journal(id=$id, name='$name')"
    }


}