package com.example.kotlinjournal.service.api

import com.example.kotlinjournal.dto.VolumeDto
import java.util.*

interface VolumeService {
    fun add(volumeDto: VolumeDto): VolumeDto
    fun getById(id: Long): VolumeDto
    fun deleteById(id: Long)
    fun edit(volumeDto: VolumeDto): VolumeDto
    fun getAll(): List<VolumeDto>
}