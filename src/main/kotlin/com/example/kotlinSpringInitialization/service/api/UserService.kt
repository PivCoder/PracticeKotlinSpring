package com.example.kotlinSpringInitialization.service.api

import com.example.kotlinSpringInitialization.model.User
import java.util.*

interface UserService {
    fun addUser(user: User): User
    fun getUserById(id: Long): Optional<User>
    fun deleteUserById(id: Long)
    fun editUser(user: User)
    fun getAllUsers(): List<User>
}