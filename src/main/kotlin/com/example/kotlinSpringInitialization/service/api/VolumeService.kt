package com.example.kotlinSpringInitialization.service.api

import com.example.kotlinSpringInitialization.model.Volume
import java.util.*

interface VolumeService {
    fun addVolume(volume: Volume): Volume
    fun getVolumeById(id: Long): Optional<Volume>
    fun deleteVolumeById(id: Long)
    fun editVolume(volume: Volume)
    fun getAllVolumes(): List<Volume>
}