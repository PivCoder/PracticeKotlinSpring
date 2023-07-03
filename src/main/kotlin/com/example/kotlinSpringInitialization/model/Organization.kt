package com.example.kotlinSpringInitialization.model

import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "organization")
class Organization(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "organization_seq")
    @SequenceGenerator(name = "organization_seq",
                       sequenceName = "project.organizations_id")
    val id: Long,
    val name: String,

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    val authors: List<Author>) {

    override fun toString(): String {
        return "Organization(id=$id, name='$name')"
    }
}