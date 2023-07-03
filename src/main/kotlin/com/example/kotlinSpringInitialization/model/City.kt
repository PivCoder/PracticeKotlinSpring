package com.example.kotlinSpringInitialization.model

import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "cities")
class City(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "city_seq")
    @SequenceGenerator(name = "city_seq",
                       sequenceName = "project.cities_id")
    val id: Long,
    val name: String,

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    val users: List<User>) {

    override fun toString(): String {
        return "City(id=$id, name='$name')"
    }
}