package com.hotshi.com.hotshi.ebookStore.models.interfaces

import java.time.LocalDateTime

interface IEBook {
    val idBook: String
    val title: String
    val author: String
    val publishedDate: LocalDateTime
    val description: String
    val isbn: String
    val category: String
    val price: Int
    val fileName: String?
    val fileURL: String?
    val thumbnail: String?
    val uploadedAt: LocalDateTime?
    val idUser: String
}