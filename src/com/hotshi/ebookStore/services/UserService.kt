package com.hotshi.com.hotshi.ebookStore.services

import com.hotshi.com.hotshi.ebookStore.models.User
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IRoleRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository

class UserService(private val userRepository: IUserRepository, private val roleRepository: IRoleRepository) {

    suspend fun findUserById(idUser: String): User? {
        var user = userRepository.findById(idUser)
        user?.roles = roleRepository.getUserRoles(idUser)
        return user
    }


}