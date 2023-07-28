package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.dto.VolumeDto
import org.springframework.data.jpa.repository.JpaRepository

interface VolumeRepository : JpaRepository<VolumeDto, Long>