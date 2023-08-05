package com.example.kotlinjournal.repositoryes

import com.example.kotlinjournal.model.Volume
import org.springframework.data.jpa.repository.JpaRepository

interface VolumeRepository : JpaRepository<Volume, Long>