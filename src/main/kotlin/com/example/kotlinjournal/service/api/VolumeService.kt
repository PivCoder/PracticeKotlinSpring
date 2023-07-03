package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.model.Volume
import java.util.*

interface VolumeService {
    fun addVolume(volume: Volume): Volume
    fun getVolumeById(id: Long): Optional<Volume>
    fun deleteVolumeById(id: Long)
    fun editVolume(volume: Volume)
    fun getAllVolumes(): List<Volume>
}