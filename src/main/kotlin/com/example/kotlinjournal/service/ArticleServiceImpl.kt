package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.ArticleDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.repositoryes.ArticleRepository
import com.example.kotlinjournal.service.api.ArticleService
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl(
    private val articleRepository: ArticleRepository) : ArticleService {

    override fun add(articleDto: ArticleDto): ArticleDto {
        articleRepository.save(articleDto.toEntity())
        return articleDto
    }

    override fun getById(id: Long): ArticleDto {
        val article = articleRepository.findById(id).map {
            ArticleDto(
                it.id,
                it.name,
                it.pictureRef,
                it.category,
                it.volume,
                it.countVisits,
                it.countPages,
                it.state)
        }.orElseThrow{
            throw ElementNotFoundException()
        }

        return article
    }

    override fun deleteById(id: Long) {
        articleRepository.deleteById(id)
    }

    override fun edit(articleDto: ArticleDto): ArticleDto {
        articleRepository.findById(articleDto.id)
            .orElseThrow{
                throw ElementNotFoundException()
            }

        articleRepository.save(articleDto.toEntity())
        return articleDto
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