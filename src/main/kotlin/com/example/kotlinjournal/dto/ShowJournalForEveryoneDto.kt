package com.example.kotlinjournal.dto

import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.model.Volume

data class ShowJournalForEveryoneDto(
    val name: String,
    val publisher: Publisher,
    val volumes: List<Volume>,
)