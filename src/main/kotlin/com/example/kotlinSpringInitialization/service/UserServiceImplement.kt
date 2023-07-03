package com.example.kotlinSpringInitialization.service

import com.example.kotlinSpringInitialization.model.User
import com.example.kotlinSpringInitialization.repositoryes.UserRepository
import com.example.kotlinSpringInitialization.service.api.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImplement(private val userRepository: UserRepository) : UserService {
    override fun addUser(user: User): User {
        return userRepository.save(user)
    }

    override fun getUserById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    override fun deleteUserById(id: Long) {
        userRepository.deleteById(id)
    }

    override fun editUser(user: User) {
        userRepository.save(user)
    }

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}