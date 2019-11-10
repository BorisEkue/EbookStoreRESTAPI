package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object Authors : Table("authors") {
    val idAuthor = varchar("id_author", 50).primaryKey()
    val name = varchar("name", 255)

}