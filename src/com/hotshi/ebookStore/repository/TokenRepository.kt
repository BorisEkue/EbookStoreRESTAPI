package com.hotshi.com.hotshi.ebookStore.repository

import com.hotshi.com.hotshi.ebookStore.dao.Tokens
import com.hotshi.com.hotshi.ebookStore.models.Token
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.ITokenRepository
import com.hotshi.com.hotshi.ebookStore.utils.generateIdByCustomer
import com.hotshi.com.hotshi.ebookStore.utils.generateUserTokenKey
import com.hotshi.com.hotshi.ebookStore.utils.toDateTime
import com.hotshi.com.hotshi.ebookStore.utils.toLocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.transaction
import org.joda.time.DateTime
import java.time.LocalDateTime

class TokenRepository: ITokenRepository {

    override suspend fun create(idUser: String): Token {
        val token = generateToken(idUser)
        transaction {
            Tokens.insert {
                it[Tokens.idToken] = token.idToken
                it[Tokens.idUser] = token.idUser
                it[Tokens.key] = token.key
                it[Tokens.createdAt] = toDateTime(token.createdAt)
            }
        }
        return token
    }

    override suspend fun findByKey(key: String): Token? = transaction {
        Tokens.select { Tokens.key.eq(key) }
            .mapNotNull { Token(it[Tokens.idToken], it[Tokens.idUser], it[Tokens.key],  toLocalDateTime(it[Tokens.createdAt])) }
            .firstOrNull()
    }

    private fun generateToken(idUser: String): Token {
        val idToken = generateIdByCustomer("t", idUser)
        val key = generateUserTokenKey(idUser)
        return Token(idToken, idUser, key, LocalDateTime.now())

    }
}