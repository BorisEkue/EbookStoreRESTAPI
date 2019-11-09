package com.hotshi.com.hotshi.ebookStore.services

import com.hotshi.com.hotshi.ebookStore.models.Token
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.ITokenRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository

class AuthenticationService(private val userRepository: IUserRepository, private val tokenRepository: ITokenRepository)  {

     suspend fun login(email: String, password: String): LoggedUser? {
        val user = userRepository.findUser(email, password)
        user?.let{
            // Generate user token
            val token = tokenRepository.create(user.idUser)
            return LoggedUser(user.idUser, token)
        } ?: return null
    }


}

data class LoggedUser(val idUser: String, val token: Token)