package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.VolumeDto
import com.example.kotlinjournal.service.api.VolumeService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/volume")
class VolumeController(private val volumeService: VolumeService) {
    @GetMapping
    fun showAll(): List<VolumeDto> {
        return volumeService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<VolumeDto> {
        return volumeService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody volumeDto: VolumeDto) : VolumeDto {
        return volumeService.add(volumeDto)
    }

    @PutMapping
    fun update(@RequestBody volumeDto: VolumeDto) : VolumeDto {
        return volumeService.edit(volumeDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        volumeService.deleteById(id)
    }
}