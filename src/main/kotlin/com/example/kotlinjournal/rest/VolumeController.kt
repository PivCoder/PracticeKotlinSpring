package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.dto.VolumeDto
import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.service.api.VolumeService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/volume")
class VolumeController(private val volumeService: VolumeService) {
    @GetMapping("/all")
    fun showAll(): List<VolumeDto> {
        return volumeService.getAll()
    }

    @GetMapping("/{id}")
    fun showOne(@PathVariable id: Long): Optional<VolumeDto> {
        return volumeService.getById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody volumeDto: VolumeDto) : Volume {
        return volumeService.add(volumeDto);
    }

    @PutMapping("/update")
    fun update(@RequestBody volumeDto: VolumeDto) : Volume {
        return volumeService.edit(volumeDto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long){
        volumeService.deleteById(id)
    }
}