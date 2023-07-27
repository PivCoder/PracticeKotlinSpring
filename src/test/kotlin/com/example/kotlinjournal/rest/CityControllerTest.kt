package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.service.api.CityService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@AutoConfigureMockMvc
@Testcontainers
internal class CityControllerTest : DockerEnvocker() {

    //TODO Скорее всего конфликт зависимостей
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var cityService: CityService

    @Test
    @Order(1)
    fun create() {
        val testCityDto = CityDto(
            id = 1,
            name = "Qatar"
        )

        cityService.add(testCityDto)

        val retrievedCity = cityService.getById(1)

        assertNotNull(retrievedCity)
        assertEquals("Qatar", retrievedCity.get().name)
        println("ОТРАБОТАЛО СОЗДАНИЕ")
    }

    @Test
    @Order(2)
    fun read(){
        val retrievedCityByName = cityService.getByName("Qatar")
        println(retrievedCityByName)
        val retrievedCityById = cityService.getById(1)
        println(retrievedCityById)
        println("ОТРАБОТАЛО ЧТЕНИЕ")
    }

    @Test
    @Order(3)
    fun update(){
        val testCityDto = CityDto(
            id = 1,
            name = "Morocco"
        )

        cityService.edit(testCityDto)

        println(testCityDto)
        println("ОТРАБОТАЛО ИЗМЕНЕНИЕ")
    }

    @Test
    @Order(4)
    fun delete(){
        cityService.deleteById(1)
        println("ОТРАБОТАЛО УДАЛЕНИЕ")
    }
}