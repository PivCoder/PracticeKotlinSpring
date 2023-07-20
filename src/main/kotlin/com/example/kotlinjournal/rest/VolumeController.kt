package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.VolumeDto
import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.service.api.VolumeService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/volume")
class VolumeController(private val volumeService: VolumeService) {
    @GetMapping("/all")
    fun showAllArticles(): List<VolumeDto> {
        return volumeService.getAll()
    }

    @GetMapping("/{id}")
    fun showOneArticle(@PathVariable id: Long): Optional<VolumeDto> {
        return volumeService.getById(id)
    }

    @PostMapping("/create")
    fun createArticle(@RequestBody volumeDto: VolumeDto) : Volume {
        return volumeService.add(volumeDto);
    }
}