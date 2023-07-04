package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.repositoryes.ArticleRepository
import com.example.kotlinjournal.service.api.ArticleService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticleServiceImpl(private val articleRepository: ArticleRepository) : ArticleService {

    override fun add(article: Article): Article {
        return articleRepository.save(article)
    }

    override fun getById(id: Long): Optional<Article> {
        return articleRepository.findById(id)
    }

    override fun deleteById(id: Long) {
        articleRepository.deleteById(id)
    }

    override fun edit(article: Article) {
        articleRepository.save(article)
    }

    override fun getAll(): List<Article> {
        return articleRepository.findAll()
    }
}