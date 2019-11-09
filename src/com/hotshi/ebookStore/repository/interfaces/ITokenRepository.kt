package com.hotshi.com.hotshi.ebookStore.repository.interfaces

import com.hotshi.com.hotshi.ebookStore.models.Token

interface ITokenRepository {
    suspend fun findByKey(key: String): Token?
    suspend fun create(idUser: String): Token
}