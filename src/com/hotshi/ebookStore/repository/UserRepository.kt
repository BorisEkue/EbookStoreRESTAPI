package com.hotshi.com.hotshi.ebookStore.repository

import com.hotshi.com.hotshi.ebookStore.models.Role
import com.hotshi.com.hotshi.ebookStore.models.User
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IRole
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository

class UserRepository : IUserRepository {
    override fun findUser(email: String, password: String): User {
        val roles: ArrayList<IRole> = ArrayList()
        roles.add(Role("1", "buyer"))

        return User( "125", "Boris",
            "EKUE","boris@gmail.com", "pass", roles )
    }
}