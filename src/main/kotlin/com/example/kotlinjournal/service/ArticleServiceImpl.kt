package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.repositoryes.ArticleRepository
import com.example.kotlinjournal.service.api.ArticleService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticleServiceImpl(
    private val articleRepository: ArticleRepository) : ArticleService {

    override fun add(articleDto: ArticleDto): Article {
        return articleRepository.save(articleDto.toEntity())
    }

    override fun getById(id: Long): Optional<ArticleDto> {
        return articleRepository.findById(id).map {
            ArticleDto(
                it.id,
                it.name,
                it.pictureRef,
                it.category,
                it.volume,
                it.countVisits,
                it.countPages,
                it.state
            )
        }
    }

    override fun deleteById(id: Long) {
        articleRepository.deleteById(id)
    }

    override fun edit(articleDto: ArticleDto): Article {
        articleRepository.findById(articleDto.id)
            .orElseThrow{
                throw ElementNotFoundException("Article with id " + articleDto.id + " not found!")
            }

        return articleRepository.save(articleDto.toEntity())
    }

    override fun getAll(): List<ArticleDto> {
        return articleRepository.findAll().map {
            ArticleDto(
                it.id,
                it.name,
                it.pictureRef,
                it.category,
                it.volume,
                it.countVisits,
                it.countPages,
                it.state
            )
        }
    }
}