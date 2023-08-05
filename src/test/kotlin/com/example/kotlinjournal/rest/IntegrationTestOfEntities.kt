package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.*
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import com.example.kotlinjournal.model.enums.UserTypes
import com.example.kotlinjournal.service.api.*
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
class IntegrationTestOfEntities : DockerInvoker(){

    @Autowired
    private lateinit var articleService: ArticleService

    @Autowired
    private lateinit var authorService: AuthorService

    @Autowired
    private lateinit var cityService: CityService

    @Autowired
    private lateinit var journalService: JournalService

    @Autowired
    private lateinit var organizationService: OrganizationService

    @Autowired
    private lateinit var publisherService: PublisherService

    @Autowired
    private lateinit var volumeService: VolumeService

    @Test
    @Order(1)
    fun create() {
        val testPublisher = PublisherDto(
            id = 1,
            name = "TestPublisher",
            ISSN = "1234-1234"
        )
        val returnedPublisherDto = publisherService.add(testPublisher)

        val testJournal = JournalDto(
            id = 1,
            name = "TestJournal",
            publisher = returnedPublisherDto.toEntity()
        )
        val returnedJournalDto = journalService.add(testJournal)

        val testVolume = VolumeDto(
            id = 1,
            name = "TestVolume",
            journal = returnedJournalDto.toEntity()
        )
        val returnedVolumeDto = volumeService.add(testVolume)

        val testArticle = ArticleDto(
            id = 1,
            name = "TestArticle",
            pictureRef = "",
            category = Categories.CHEMISTRY,
            state = States.UNDER_CONSIDERATION,
            volume = returnedVolumeDto.toEntity(),
            countPages = 0,
            countVisits = 0
        )
        val returnedArticleDto = articleService.add(testArticle)

        val testOrganization = OrganizationDto(
            id = 1,
            name = "TestOrganization"
        )
        val returnedOrganizationDto = organizationService.add(testOrganization)

        val testCityDto = CityDto(
            id = 1,
            name = "Qatar"
        )
        val returnedCityDto = cityService.add(testCityDto)

        val testAuthor = AuthorDto(
            id = 1,
            name = "TestName",
            surname = "TestSurname",
            patronymic = "",
            rating = 0.0F,
            pictureRef = "",
            userType = UserTypes.USER,
            organization = returnedOrganizationDto.toEntity(),
            city = returnedCityDto.toEntity(),
            articles = mutableListOf(returnedArticleDto.toEntity())
        )
        val returnedAuthor = authorService.add(testAuthor)

        println("ОТРАБОТАЛО СОЗДАНИЕ")
    }
}