package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object Users : Table("users") {
    val idUser = varchar("id_user", 50).primaryKey()
    val firstName = varchar("first_name", 255)
    val lastName = varchar("last_name", 255)
    val email = varchar("email", 50)
    val password = varchar("password", 50)
}