package com.hotshi.com.hotshi.ebookStore.models.interfaces

import java.time.LocalDateTime

interface IEBook {
    val idBook: String
    val title: String
    val authorsId: ArrayList<String>
    val publishedDate: LocalDateTime
    val description: String
    val isbn: String
}