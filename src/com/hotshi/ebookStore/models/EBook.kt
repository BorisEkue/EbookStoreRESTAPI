package com.hotshi.com.hotshi.ebookStore.models

import com.hotshi.com.hotshi.ebookStore.models.interfaces.IEBook
import java.time.LocalDateTime

data class EBook(
    override val idBook: String,
    override val title: String,
    override val authorsId: ArrayList<String>,
    override val publishedDate: LocalDateTime,
    override val description: String,
    override val isbn: String
) : IEBook