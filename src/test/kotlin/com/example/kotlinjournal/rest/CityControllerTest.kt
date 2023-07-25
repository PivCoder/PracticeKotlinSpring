package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.CityDto
import com.example.kotlinjournal.service.api.CityService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
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
@AutoConfigureMockMvc
@Testcontainers
internal class CityControllerTest {

    companion object {
        @Container
        private val postgreSQLContainer = PostgreSQLContainer("postgres:14")
            .withDatabaseName("Journal")

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl)
            registry.add("spring.datasource.password", postgreSQLContainer::getPassword)
            registry.add("spring.datasource.username", postgreSQLContainer::getUsername)
        }
    }

    //TODO Скорее всего конфликт зависимостей
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var cityService: CityService

    @Test
    fun createCity() {
        val testCityDto = CityDto(
            id = 4,
            name = "Qatar"
        )

        cityService.add(testCityDto)

        val retrievedCity = cityService.getById(4)

        assertNotNull(retrievedCity)
        assertEquals("Qatar", retrievedCity.get().name)
    }
}