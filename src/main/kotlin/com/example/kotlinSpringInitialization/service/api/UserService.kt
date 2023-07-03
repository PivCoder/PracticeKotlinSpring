package com.example.kotlinSpringInitialization.service.api

import com.example.kotlinSpringInitialization.model.Author
import java.util.*

interface UserService {
    fun addUser(author: Author): Author
    fun getUserById(id: Long): Optional<Author>
    fun deleteUserById(id: Long)
    fun editUser(author: Author)
    fun getAllUsers(): List<Author>
}