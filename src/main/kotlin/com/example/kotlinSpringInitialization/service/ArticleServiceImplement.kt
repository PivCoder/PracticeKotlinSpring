package com.example.kotlinSpringInitialization.service

import com.example.kotlinSpringInitialization.model.Article
import com.example.kotlinSpringInitialization.repositoryes.ArticleRepository
import com.example.kotlinSpringInitialization.service.api.ArticleService
import org.springframework.stereotype.Service
import java.util.*

//TODO брать упоминане article в реализации функции. +dto
@Service
class ArticleServiceImplement(private val articleRepository: ArticleRepository) : ArticleService {

    override fun addArticle(article: Article): Article {
        return articleRepository.save(article)
    }

    override fun getArticleById(id: Long): Optional<Article> {
        return articleRepository.findById(id)
    }

    override fun deleteArticleById(id: Long) {
        articleRepository.deleteById(id)
    }

    override fun editArticle(article: Article) {
        articleRepository.save(article)
    }

    override fun getAllArticles(): List<Article> {
        return articleRepository.findAll()
    }
}