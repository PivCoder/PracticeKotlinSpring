package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.repositoryes.VolumeRepository
import com.example.kotlinjournal.service.api.VolumeService
import org.springframework.stereotype.Service
import java.util.*

@Service
class VolumeServiceImpl(private val volumeRepository: VolumeRepository) : VolumeService {
    override fun add(volume: Volume): Volume {
        return volumeRepository.save(volume)
    }

    override fun getById(id: Long): Optional<Volume> {
        return volumeRepository.findById(id)
    }

    override fun deleteById(id: Long) {
        volumeRepository.deleteById(id)
    }

    override fun edit(volume: Volume) {
        volumeRepository.save(volume)
    }

    override fun getAll(): List<Volume> {
        return volumeRepository.findAll()
    }
}