package com.example.kotlinjournal.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.jetbrains.annotations.NotNull

@MappedSuperclass
abstract class AbstractEntity(
    @Id
    @field:NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?
)