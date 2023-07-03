package com.example.kotlinjournal.model

import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "city")
class City(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "city_seq")
    @SequenceGenerator(name = "city_seq",
                       sequenceName = "project.cities_id")
    val id: Long,
    val name: String,

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    val authors: List<Author>) {

    override fun toString(): String {
        return "City(id=$id, name='$name')"
    }
}