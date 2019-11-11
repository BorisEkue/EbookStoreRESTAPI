package com.hotshi.com.hotshi.ebookStore.repository

import com.hotshi.com.hotshi.ebookStore.dao.Ebooks
import com.hotshi.com.hotshi.ebookStore.models.EBook
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IEBook
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IEbookRepository
import com.hotshi.com.hotshi.ebookStore.utils.generateIdByCustomer
import com.hotshi.com.hotshi.ebookStore.utils.toDateTime
import com.hotshi.com.hotshi.ebookStore.utils.toLocalDateTime
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EBookRepository: IEbookRepository {
    override suspend fun upload(eBook: IEBook) {

    }

    override suspend fun save(eBook: IEBook) {
        transaction {
            Ebooks.insert {
                it[Ebooks.idEbook] = eBook.idBook
                it[Ebooks.title] = eBook.title
                it[Ebooks.author] = eBook.author
                it[Ebooks.publishedDate] = toDateTime(eBook.publishedDate)
                it[Ebooks.isbn] = eBook.isbn
                it[Ebooks.description] = eBook.description
                it[Ebooks.category] = eBook.category
                it[Ebooks.fileName] = eBook.fileName ?: ""
                it[Ebooks.fileURL] = eBook.fileURL ?: ""
                it[Ebooks.thumbnail] = eBook.thumbnail ?: ""
                it[Ebooks.uploadedAt] = toDateTime(eBook.uploadedAt!!)
                it[Ebooks.idUser] = eBook.idUser
            }
        }

    }

    override suspend fun all(category: String) = transaction {
        if(category == "all")
            Ebooks.selectAll()
                .orderBy(Ebooks.uploadedAt, SortOrder.DESC)
                .mapNotNull { EBook(
                    idBook = it[Ebooks.idEbook],
                    title = it[Ebooks.title],
                    author = it[Ebooks.author],
                    publishedDate = toLocalDateTime(it[Ebooks.publishedDate]),
                    description = it[Ebooks.description],
                    isbn = it[Ebooks.isbn],
                    category = it[Ebooks.category],
                    price = it[Ebooks.price],
                    fileName = it[Ebooks.fileName],
                    fileURL = it[Ebooks.fileURL],
                    thumbnail = it[Ebooks.thumbnail],
                    uploadedAt = toLocalDateTime(it[Ebooks.uploadedAt]),
                    idUser = it[Ebooks.idUser]
                ) }
        else
            Ebooks.select { Ebooks.category eq category }
                .orderBy(Ebooks.uploadedAt, SortOrder.DESC)
                .mapNotNull { EBook(
                    idBook = it[Ebooks.idEbook],
                    title = it[Ebooks.title],
                    author = it[Ebooks.author],
                    publishedDate = toLocalDateTime(it[Ebooks.publishedDate]),
                    description = it[Ebooks.description],
                    isbn = it[Ebooks.isbn],
                    category = it[Ebooks.category],
                    price = it[Ebooks.price],
                    fileName = it[Ebooks.fileName],
                    fileURL = it[Ebooks.fileURL],
                    thumbnail = it[Ebooks.thumbnail],
                    uploadedAt = toLocalDateTime(it[Ebooks.uploadedAt]),
                    idUser = it[Ebooks.idUser]
                ) }
    }

    override suspend fun findById(idEbook: String) = transaction {
        Ebooks.select { Ebooks.idEbook eq idEbook }
            .mapNotNull { EBook(
                idBook = it[Ebooks.idEbook],
                title = it[Ebooks.title],
                author = it[Ebooks.author],
                publishedDate = toLocalDateTime(it[Ebooks.publishedDate]),
                description = it[Ebooks.description],
                isbn = it[Ebooks.isbn],
                category = it[Ebooks.category],
                price = it[Ebooks.price],
                fileName = it[Ebooks.fileName],
                fileURL = it[Ebooks.fileURL],
                thumbnail = it[Ebooks.thumbnail],
                uploadedAt = toLocalDateTime(it[Ebooks.uploadedAt]),
                idUser = it[Ebooks.idUser]
            )  }
            .firstOrNull()
    }
}