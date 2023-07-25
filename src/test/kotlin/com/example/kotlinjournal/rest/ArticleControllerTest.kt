package com.example.kotlinjournal.rest

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.model.Volume
import com.example.kotlinjournal.model.enums.Categories
import com.example.kotlinjournal.model.enums.States
import com.example.kotlinjournal.service.api.ArticleService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
internal class ArticleControllerTest {

    @Autowired
    private lateinit var articleService: ArticleService

    @MockBean
    private lateinit var volume: Volume

    @MockBean
    private lateinit var authors: MutableList<Author>

    @Test
    fun createArticle() {
        val articleDto = ArticleDto(
            id = 5,
            name = "Test article 5",
            state = States.UNDER_CONSIDERATION,
            countVisits = 0,
            countPage = 0,
            volume = volume,
            pictureRef = "",
            category = Categories.CHEMISTRY,
        )

        articleService.add(articleDto)

        val retrievedArticle = articleService.getById(1)

        assertNotNull(retrievedArticle)
        assertEquals("Test article", retrievedArticle.get().name)
        assertEquals(States.UNDER_CONSIDERATION, retrievedArticle.get().state)
        assertEquals(Categories.CHEMISTRY, retrievedArticle.get().category)
    }
}