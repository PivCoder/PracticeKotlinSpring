package com.example.kotlinSpringInitialization.repositoryes

import com.example.kotlinSpringInitialization.model.Volume
import org.springframework.data.jpa.repository.JpaRepository

interface VolumeRepository : JpaRepository<Volume, Long>