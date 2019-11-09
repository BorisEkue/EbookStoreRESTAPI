package com.hotshi.com.hotshi.ebookStore.routes

import com.hotshi.com.hotshi.ebookStore.http.error
import com.hotshi.com.hotshi.ebookStore.http.response
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IRoleRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import com.hotshi.com.hotshi.ebookStore.services.UserService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.route
import io.ktor.routing.get

fun Route.usersRoutes(userRepository: IUserRepository, roleRepository: IRoleRepository) {
    route("/users") {
        val userService = UserService(userRepository, roleRepository)

        get("/{id_user}") {
            val idUser = call.parameters["id_user"]
            idUser?.let {
                //val user = userRepository.findUser()
                val user = userService.findUserById(idUser)
                user?.let {
                    call.respond(response(HttpStatusCode.OK, call, "user", user))
                } ?: call.respond(error(HttpStatusCode.NotFound, call, "User not found"))
            } ?: call.respond(error( HttpStatusCode.NotFound, call, "id_user can not be empty") )
        }
    }
}