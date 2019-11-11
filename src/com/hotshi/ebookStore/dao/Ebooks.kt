package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object Ebooks : Table("ebooks") {
    val idEbook = varchar("id_ebook", 50).primaryKey()
    val title = varchar("title", 255)
    val author = varchar("author", 255)
    val publishedDate = datetime("published_date")
    val description = varchar("description", 255)
    val isbn = varchar("isbn", 50)
    val category = varchar("category", 50)
    val price = integer("price")
    val fileName = varchar("file_name", 255)
    val fileURL = varchar("file_url", 255)
    val thumbnail = varchar("thumbnail", 255)
    val uploadedAt = datetime("uploaded_at")
    val idUser = varchar("id_user", 255)

}