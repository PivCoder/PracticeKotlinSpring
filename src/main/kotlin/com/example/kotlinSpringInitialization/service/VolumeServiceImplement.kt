package com.example.kotlinSpringInitialization.service

import com.example.kotlinSpringInitialization.model.Volume
import com.example.kotlinSpringInitialization.repositoryes.VolumeRepository
import com.example.kotlinSpringInitialization.service.api.VolumeService
import org.springframework.stereotype.Service
import java.util.*

@Service
class VolumeServiceImplement(private val volumeRepository: VolumeRepository) : VolumeService {
    override fun addVolume(volume: Volume): Volume {
        return volumeRepository.save(volume)
    }

    override fun getVolumeById(id: Long): Optional<Volume> {
        return volumeRepository.findById(id)
    }

    override fun deleteVolumeById(id: Long) {
        volumeRepository.deleteById(id)
    }

    override fun editVolume(volume: Volume) {
        volumeRepository.save(volume)
    }

    override fun getAllVolumes(): List<Volume> {
        return volumeRepository.findAll()
    }
}