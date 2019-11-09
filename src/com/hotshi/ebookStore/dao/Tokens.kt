package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object Tokens : Table("tokens") {
    val idToken = varchar("id_token", 255).primaryKey()
    val idUser = varchar("id_user", 255)
    val key = varchar("key", 255)
    val createdAt = datetime("created_at")
}