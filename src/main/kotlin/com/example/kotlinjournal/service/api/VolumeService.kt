package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Volume
import java.util.*

interface VolumeService {
    fun add(volume: Volume): Volume
    fun getById(id: Long): Optional<Volume>
    fun deleteById(id: Long)
    fun edit(volume: Volume)
    fun getAll(): List<Volume>
}