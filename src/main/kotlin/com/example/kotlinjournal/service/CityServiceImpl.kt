package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.model.City
import com.example.kotlinjournal.repositoryes.CityRepository
import com.example.kotlinjournal.service.api.CityService
import org.springframework.stereotype.Service
import java.util.*

//TODO почитать за инверсию управления
@Service
class CityServiceImpl(private val cityRepository: CityRepository) : CityService{
    override fun add(cityDto: CityDto): City {
        return cityRepository.save(cityDto.toEntity())
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

    override fun edit(cityDto: CityDto) {
        cityRepository.save(cityDto.toEntity())
    }

    //TODO почитать за MapStruct. Метод .map трансформирует передаваемые значения по условию и возвращает List
    override fun getAll(): List<CityDto> {
        return cityRepository.findAll().map {
            CityDto(it.id, it.name)
        }
    }
}