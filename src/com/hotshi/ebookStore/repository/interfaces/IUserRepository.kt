package com.hotshi.com.hotshi.ebookStore.repository.interfaces

import com.hotshi.com.hotshi.ebookStore.models.User

interface IUserRepository {
    suspend fun findUser(email: String, password: String): User?
    suspend fun findById(idUser: String): User?
}