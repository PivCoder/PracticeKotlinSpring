package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.Article
import com.example.kotlinjournal.repositoryes.ArticleRepository
import com.example.kotlinjournal.service.api.ArticleService
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