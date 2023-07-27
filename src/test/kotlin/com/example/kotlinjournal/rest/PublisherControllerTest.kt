package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.PublisherDto
import com.example.kotlinjournal.service.api.PublisherService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@AutoConfigureMockMvc
@Testcontainers
internal class PublisherControllerTest : DockerEnvocker(){

    @Autowired
    private lateinit var publisherService: PublisherService

    @Test
    @Order(1)
    fun create() {
        val testPublisherDto = PublisherDto(
            id = 1,
            name = "My test publisher",
            ISSN = "1234-1234"
        )

        publisherService.add(testPublisherDto)

        val retrievedCity = publisherService.getById(1)

        assertNotNull(retrievedCity)
        assertEquals("My test publisher", retrievedCity.get().name)
        println("ОТРАБОТАЛО СОЗДАНИЕ")
    }

    @Test
    @Order(2)
    fun showOne() {
        println(publisherService.getById(1))
        println("ОТРАБОТАЛО ЧТЕНИЕ")
    }

    @Test
    @Order(3)
    fun showAll() {
        println(publisherService.getAll())
        println("ОТРАБОТАЛО ЧТЕНИЕ ВСЕХ")
    }

    @Test
    @Order(4)
    fun update() {
        val testPublisherDto = PublisherDto(
            id = 1,
            name = "My test edited publisher",
            ISSN = "0000-0000"
        )

        println(publisherService.edit(testPublisherDto))
        println("ОТРАБОТАЛО ОБНОВЛЕНИЕ")
    }

    @Test
    @Order(5)
    fun delete() {
        publisherService.deleteById(1)
        println("ОТРАБОТАЛО УДАЛЕНИЕ")
    }
}