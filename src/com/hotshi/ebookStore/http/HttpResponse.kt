package com.hotshi.com.hotshi.ebookStore.http

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.uri

fun response(httpStatusCode: HttpStatusCode, call: ApplicationCall, dataKey: String, data: Any): JsonNode {
    call.response.status(httpStatusCode)
    val responseNode = ObjectMapper().createObjectNode()

    responseNode.put("status", httpStatusCode.value)
    responseNode.put("uri", call.request.uri)
    responseNode.putPOJO(dataKey, data)
    return responseNode
}

fun error(httpStatusCode: HttpStatusCode, call: ApplicationCall, errorDescription: String): JsonNode {
    call.response.status(httpStatusCode)
    val errorNode = ObjectMapper().createObjectNode()

    errorNode.put("status", httpStatusCode.value)
    errorNode.put("uri", call.request.uri)
    errorNode.put("error", httpStatusCode.description)
    errorNode.put("error_description", errorDescription)
    return errorNode
}