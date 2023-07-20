package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.exception.ElementNotFoundException
import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.repositoryes.AuthorRepository
import com.example.kotlinjournal.service.api.AuthorService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {
    override fun add(authorDto: AuthorDto): Author {
        return authorRepository.save(authorDto.toEntity())
    }

    override fun getById(id: Long): Optional<AuthorDto> {
        return authorRepository.findById(id).map {
            AuthorDto(
                it.id,
                it.name,
                it.surname,
                it.patronymic,
                it.pictureRef,
                it.organization,
                it.city,
                it.rating,
                it.userType
            )
        }
    }

    override fun deleteById(id: Long) {
        authorRepository.deleteById(id)
    }

    override fun edit(authorDto: AuthorDto): Author {
        authorRepository.findById(authorDto.id)
            .orElseThrow{throw ElementNotFoundException("Author with id " + authorDto.id + " not found!") }

        return authorRepository.save(authorDto.toEntity())
    }

    override fun getAll(): List<AuthorDto> {
        return authorRepository.findAll().map {
            AuthorDto(
                it.id,
                it.name,
                it.surname,
                it.patronymic,
                it.pictureRef,
                it.organization,
                it.city,
                it.rating,
                it.userType
            )
        }
    }
}