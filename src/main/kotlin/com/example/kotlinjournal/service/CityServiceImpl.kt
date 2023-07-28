package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.repositoryes.CityRepository
import com.example.kotlinjournal.service.api.CityService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CityServiceImpl(private val cityRepository: CityRepository) : CityService{
    override fun add(cityDto: CityDto): CityDto {
        return cityRepository.save(cityDto)
    }

    override fun getById(id: Long): Optional<CityDto> {
        return cityRepository.findById(id).map {
            CityDto(it.id, it.name)
        }
    }

    override fun getByName(name: String): Optional<CityDto> {
        return cityRepository.findByName(name).map {
            CityDto(it.id, it.name)
        }
    }

    override fun deleteById(id: Long) {
        cityRepository.deleteById(id)
    }

    override fun edit(cityDto: CityDto): CityDto {
        cityRepository.findById(cityDto.id)
            .orElseThrow{
                throw ElementNotFoundException("City with id " + cityDto.id + " not found!")
            }

        return cityRepository.save(cityDto)
    }

    override fun getAll(): List<CityDto> {
        return cityRepository.findAll().map {
            CityDto(it.id, it.name)
        }
    }
}