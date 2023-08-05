package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.VolumeDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.repositoryes.VolumeRepository
import com.example.kotlinjournal.service.api.VolumeService
import org.springframework.stereotype.Service
import java.util.*

@Service
class VolumeServiceImpl(private val volumeRepository: VolumeRepository) : VolumeService {
    override fun add(volumeDto: VolumeDto): VolumeDto {
        volumeRepository.save(volumeDto.toEntity())
        return volumeDto
    }

    override fun getById(id: Long): Optional<VolumeDto> {
        return volumeRepository.findById(id).map {
            VolumeDto(
                it.id,
                it.name,
                it.journal
            )
        }
    }

    override fun deleteById(id: Long) {
        volumeRepository.deleteById(id)
    }

    override fun edit(volumeDto: VolumeDto): VolumeDto {
        volumeRepository.findById(volumeDto.id)
            .orElseThrow{
                throw ElementNotFoundException("Volume with id " + volumeDto.id + " not found!")
            }

        volumeRepository.save(volumeDto.toEntity())
        return volumeDto
    }

    override fun getAll(): List<VolumeDto> {
        return volumeRepository.findAll().map {
            VolumeDto(
                it.id,
                it.name,
                it.journal
            )
        }
    }
}