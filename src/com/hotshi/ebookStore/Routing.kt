package com.hotshi.com.hotshi.ebookStore

import com.hotshi.com.hotshi.ebookStore.repository.RoleRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IEbookRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IRoleRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.ITokenRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import com.hotshi.com.hotshi.ebookStore.routes.authenticationRoutes
import com.hotshi.com.hotshi.ebookStore.routes.booksRoutes
import com.hotshi.com.hotshi.ebookStore.routes.usersRoutes
import io.ktor.routing.Routing

fun Routing.setup(
    userRepository: IUserRepository,
    tokenRepository: ITokenRepository,
    roleRepository: IRoleRepository,
    ebookRepository: IEbookRepository
) {
    authenticationRoutes(userRepository, tokenRepository)
    usersRoutes(userRepository, roleRepository)
    booksRoutes(userRepository,roleRepository, ebookRepository)
}