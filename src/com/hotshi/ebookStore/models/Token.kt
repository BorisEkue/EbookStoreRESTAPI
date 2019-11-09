package com.hotshi.com.hotshi.ebookStore.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IToken
import com.hotshi.com.hotshi.ebookStore.utils.LocalDateTimeDeserializer
import com.hotshi.com.hotshi.ebookStore.utils.LocalDateTimeSerializer
import java.time.Duration
import java.time.LocalDateTime

data class Token(
    override val idToken: String,
    override val idUser: String,
    override val key: String,

    @JsonProperty("created_at")
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonDeserialize(using = LocalDateTimeDeserializer::class )
    override val createdAt: LocalDateTime
) : IToken {

    /**
     * Token expires if it has more than 30 days
     */
    fun isExpired() = Duration.between(this.createdAt, LocalDateTime.now()).toDays() > 30
}