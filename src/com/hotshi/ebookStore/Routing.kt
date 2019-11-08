package com.hotshi.com.hotshi.ebookStore

import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import com.hotshi.com.hotshi.ebookStore.routes.authenticationRoutes
import io.ktor.routing.Routing

fun Routing.setup(
    userRepository: IUserRepository
) {
    authenticationRoutes(userRepository)
}