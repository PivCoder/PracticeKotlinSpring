package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.VolumeDto
import com.example.kotlinjournal.model.Volume
import java.util.*

interface VolumeService {
    fun add(volumeDto: VolumeDto): Volume
    fun getById(id: Long): Optional<VolumeDto>
    fun deleteById(id: Long)
    fun edit(volumeDto: VolumeDto)
    fun getAll(): List<VolumeDto>
}