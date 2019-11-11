package com.hotshi.com.hotshi.ebookStore.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IEBook
import com.hotshi.com.hotshi.ebookStore.utils.LocalDateTimeDeserializer
import com.hotshi.com.hotshi.ebookStore.utils.LocalDateTimeSerializer
import java.time.LocalDateTime

data class EBook(
    override val idBook: String,
    override val title: String,
    override val author: String,

    @JsonProperty("published_date")
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonDeserialize(using = LocalDateTimeDeserializer::class )
    override val publishedDate: LocalDateTime,

    override val description: String,
    override val isbn: String,
    override val category: String,
    override val price: Int,
    override val fileName: String?,
    override val fileURL: String?,
    override val thumbnail: String?,

    @JsonProperty("uploaded_at")
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonDeserialize(using = LocalDateTimeDeserializer::class )
    override val uploadedAt: LocalDateTime,

    override val idUser: String
) : IEBook