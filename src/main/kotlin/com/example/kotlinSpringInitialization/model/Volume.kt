package com.example.kotlinSpringInitialization.model

import jakarta.persistence.*

@Entity
@Table(schema = "project", name = "volumes")
class Volume(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "volume_seq")
    @SequenceGenerator(name = "volume_seq",
        sequenceName = "project.volumes_id")
    val id: Long,
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "journal_id")
    val journal: Journal,

    @OneToMany(mappedBy = "volume", fetch = FetchType.LAZY)
    val articles: List<Article>) {

    override fun toString(): String {
        return "Volume(id=$id, name='$name')"
    }
}