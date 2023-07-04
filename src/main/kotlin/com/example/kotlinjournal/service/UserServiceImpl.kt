package com.example.kotlinjournal.service

import com.example.kotlinjournal.model.Author
import com.example.kotlinjournal.repositoryes.UserRepository
import com.example.kotlinjournal.service.api.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun addUser(author: Author): Author {
        return userRepository.save(author)
    }

    override fun getUserById(id: Long): Optional<Author> {
        return userRepository.findById(id)
    }

    override fun deleteUserById(id: Long) {
        userRepository.deleteById(id)
    }

    override fun editUser(author: Author) {
        userRepository.save(author)
    }

    override fun getAllUsers(): List<Author> {
        return userRepository.findAll()
    }
}