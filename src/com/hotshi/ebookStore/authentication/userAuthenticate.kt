package com.hotshi.com.hotshi.ebookStore.authentication

import com.hotshi.com.hotshi.ebookStore.models.User
import com.hotshi.com.hotshi.ebookStore.http.error
import com.hotshi.com.hotshi.ebookStore.repository.TokenRepository
import com.hotshi.com.hotshi.ebookStore.services.UserService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.header
import io.ktor.response.respond
import io.ktor.util.AttributeKey
import io.ktor.util.pipeline.PipelineContext

suspend fun userAuthenticate(call: ApplicationCall, pipelineContext: PipelineContext<Unit, ApplicationCall>, userService: UserService, userAttributeKey: AttributeKey<User>) {
    if(!call.request.headers.contains("Authorization")) {
        call.respond(error(HttpStatusCode.Unauthorized, call, "An authentication token is missing"))
        pipelineContext.finish()
        return
    }

    val bearer = call.request.header("Authorization")?.trim() ?: ""
    if(bearer.isEmpty()) {
        call.respond(error(HttpStatusCode.Unauthorized, call, "Authentication token can't be empty"))
        pipelineContext.finish()
        return
    }

    val bearerSplit = bearer.split(" ")
    if(bearerSplit.size != 2) {
        call.respond(error(HttpStatusCode.Unauthorized, call, "Malformed authentication token"))
        pipelineContext.finish()
        return
    }

    val tokenKey = bearerSplit[1]

    val token = TokenRepository().findByKey(tokenKey)

    token?.let {
        // Check token validity
        if(token.isExpired()) {
            call.respond(error(HttpStatusCode.Unauthorized, call, "Token has expired. Try to authenticate"))
            pipelineContext.finish()
            return
        }

        // Token is valid. Get user infos
        call.attributes.put(userAttributeKey, userService.findUserById(token.idUser)!!)


    } ?: run {
        // Invalid token
        call.respond(error(HttpStatusCode.Unauthorized, call, "Invalid authentication token. Try to authenticate"))
        pipelineContext.finish()
        return
    }



}