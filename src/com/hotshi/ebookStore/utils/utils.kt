package com.hotshi.com.hotshi.ebookStore.utils

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.time.LocalDateTime
import java.util.*

fun generateUserTokenKey(idUser: String): String = UUID.randomUUID().toString().replace("-", "") + idUser

fun generateIdByCustomer(prefix: String, idUser: String): String {
    val randomUUID = UUID.randomUUID().toString()
    return prefix + randomUUID.replace("-", "") + idUser.replace("-", "")
}

fun toDateTime(localDateTime: LocalDateTime): DateTime {
    return DateTime(DateTimeZone.UTC)
        .withDate(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        .withTime(localDateTime.hour, localDateTime.minute, localDateTime.second, localDateTime.second)
}

fun toLocalDateTime(dateTime: DateTime): LocalDateTime {
    val dateTimeUtc = dateTime.withZone(DateTimeZone.UTC)
    return LocalDateTime.of(
        dateTimeUtc.year, dateTimeUtc.monthOfYear, dateTimeUtc.dayOfMonth,
        dateTimeUtc.hourOfDay, dateTimeUtc.minuteOfHour, dateTimeUtc.secondOfMinute
    )
}