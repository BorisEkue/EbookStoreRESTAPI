package com.hotshi.com.hotshi.ebookStore.models.interfaces

import org.joda.time.DateTime
import java.time.LocalDateTime

interface IToken {
    val idToken: String
    val idUser: String
    val key: String
    val createdAt: LocalDateTime
}