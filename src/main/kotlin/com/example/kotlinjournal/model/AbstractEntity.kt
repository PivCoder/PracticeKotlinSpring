package com.example.kotlinjournal.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.jetbrains.annotations.NotNull
import java.sql.Timestamp
import java.time.Instant

@MappedSuperclass
abstract class AbstractEntity(
    @Id
    @field:NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @CreationTimestamp
    val createdOn: Instant,

    @UpdateTimestamp
    val updatedOn: Instant
)