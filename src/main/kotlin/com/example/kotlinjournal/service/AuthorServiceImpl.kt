package com.example.kotlinjournal.service

import com.example.kotlinjournal.dto.AuthorDto
import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.repositoryes.UserRepository
import com.example.kotlinjournal.service.api.AuthorService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorServiceImpl(private val userRepository: UserRepository) : AuthorService {
    override fun add(authorDto: AuthorDto): Author {
        return userRepository.save(authorDto.toEntity())
    }

    override fun getById(id: Long): Optional<AuthorDto> {
        return userRepository.findById(id).map {
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
        userRepository.deleteById(id)
    }

    override fun edit(authorDto: AuthorDto) {
        userRepository.save(authorDto.toEntity())
    }

    override fun getAll(): List<AuthorDto> {
        return userRepository.findAll().map {
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