package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.JournalDto
import com.example.kotlinjournal.model.Publisher
import com.example.kotlinjournal.service.api.JournalService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@AutoConfigureMockMvc
@Testcontainers
internal class JournalControllerTest : DockerEnvocker(){

    @Autowired
    private lateinit var journalService: JournalService

    @Mock
    private lateinit var publisherMock: Publisher

    @Test
    fun create() {
        val testJournalDto = JournalDto(
            id = 1,
            name = "Test journal",
            publisher = publisherMock
        )

        Mockito.`when`(publisherMock.name).thenReturn("Mock")

        journalService.add(testJournalDto)

        val retrievedJournal = journalService.getById(1)

        assertNotNull(retrievedJournal)
        assertEquals("Test journal", retrievedJournal.get().name)
        println("ОТРАБОТАЛО СОЗДАНИЕ")
    }

    @Test
    fun showOne() {
        println(journalService.getById(1))
        println("ОТРАБОТАЛО ЧТЕНИЕ")
    }

    @Test
    fun showAll() {
        println(journalService.getAll())
        println("ОТРАБОТАЛО ЧТЕНИЕ ВСЕХ")
    }

    @Test
    fun update() {
        val testJournalDto = JournalDto(
            id = 1,
            name = "Test journal edited",
            publisher = publisherMock
        )

        println(journalService.edit(testJournalDto))
        println("ОТРАБОТАЛО РЕДАКТИРОВАНИЕ")
    }

    @Test
    fun delete() {
        journalService.deleteById(1)
        println("ОТРАБОТАЛО УДАЛЕНИЕ")
    }
}