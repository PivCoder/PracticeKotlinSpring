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
        cityRepository.save(cityDto.toEntity())
        return cityDto
    }

    override fun getById(id: Long): CityDto {
        val city = cityRepository.findById(id).map {
            CityDto(it.id, it.name)
        }.orElseThrow{
            throw ElementNotFoundException()
        }

        return city
    }

    override fun getByName(name: String): CityDto {
        val city = cityRepository.findByName(name).map {
            CityDto(it.id, it.name)
        }.orElseThrow{
            throw ElementNotFoundException()
        }

        return city
    }

    override fun deleteById(id: Long) {
        cityRepository.deleteById(id)
    }

    override fun edit(cityDto: CityDto): CityDto {
        cityRepository.findById(cityDto.id)
            .orElseThrow{
                throw ElementNotFoundException()
            }

        cityRepository.save(cityDto.toEntity())
        return cityDto
    }

    override fun getAll(): List<CityDto> {
        return cityRepository.findAll().map {
            CityDto(it.id, it.name)
        }
    }
}