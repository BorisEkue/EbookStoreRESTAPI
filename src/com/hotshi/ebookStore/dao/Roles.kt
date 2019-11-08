package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object Roles : Table("roles") {
    val idRole = varchar("id_role", 50).primaryKey()
    val name = varchar("name", 50)
}