package com.hotshi.com.hotshi.ebookStore.routes

import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import com.hotshi.com.hotshi.ebookStore.routes.requests.UserCredentials
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.authenticationRoutes(userRepository: IUserRepository) {
    route("/auth") {

        post("login") {
            val userCredentials = call.receive<UserCredentials>()
            val user = userRepository.findUser("", "")
            call.respond(user)
        }

        post("signup") {

        }
    }
}

