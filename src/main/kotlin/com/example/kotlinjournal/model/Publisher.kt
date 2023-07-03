package com.example.kotlinjournal.model

import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "publisher")
class Publisher (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "publisher_seq")
    @SequenceGenerator(name = "publisher_seq",
        sequenceName = "project.publishers_id")
    val id: Long,
    val name: String,
    val ISSN: String,

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    val journals: List<Journal>){

    override fun toString(): String {
        return "Publisher(id=$id, name='$name', ISSN='$ISSN')"
    }


}