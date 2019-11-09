package com.hotshi.com.hotshi.ebookStore.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer

import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeSerializer : StdSerializer<LocalDateTime>(LocalDateTime::class.java) {

    @Throws(IOException::class)
    override fun serialize(value: LocalDateTime, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
    }
}

class LocalDateTimeDeserializer : StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {



    @Throws(IOException::class)
    override  fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDateTime {
        return LocalDateTime.parse(parser.readValueAs(String::class.java))
    }
}