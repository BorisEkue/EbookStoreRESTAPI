package com.hotshi.com.hotshi.ebookStore.routes

import com.hotshi.com.hotshi.ebookStore.http.response
import com.hotshi.com.hotshi.ebookStore.http.error
import com.hotshi.com.hotshi.ebookStore.repository.TokenRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.ITokenRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import com.hotshi.com.hotshi.ebookStore.routes.requests.UserCredentials
import com.hotshi.com.hotshi.ebookStore.services.AuthenticationService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.authenticationRoutes(userRepository: IUserRepository, tokenRepository: ITokenRepository) {

    route("/auth") {
        val authenticationService = AuthenticationService(userRepository, tokenRepository)

        post("login") {
            val userCredentials = call.receive<UserCredentials>()
            val loggedUser = authenticationService.login(userCredentials.email, userCredentials.password)

            loggedUser?.let {
                call.respond(response(HttpStatusCode.OK, call, "auth", loggedUser))
            } ?:  call.respond(error(HttpStatusCode.NotFound, call, "Email/password incorrect" ))

        }

        post("signup") {

        }
    }
}

