package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object Ebooks : Table("ebooks") {
    val idEbook = varchar("id_ebook", 50).primaryKey()
    val title = varchar("title", 255)
    val publishedDate = datetime("published_date")
    val description = varchar("description", 255)
    val isbn = varchar("isbn", 50)

}