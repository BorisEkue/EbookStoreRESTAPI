package com.hotshi.com.hotshi.ebookStore.repository

import com.hotshi.com.hotshi.ebookStore.dao.Users
import com.hotshi.com.hotshi.ebookStore.models.Role
import com.hotshi.com.hotshi.ebookStore.models.User
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IRole
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.transaction

class UserRepository : IUserRepository {
    override suspend fun findUser(email: String, password: String): User? {
        val user: User? = transaction {

            Users.select {Users.email.eq(email) and Users.password.eq(password)}
                .mapNotNull { User(it[Users.idUser], it[Users.firstName], it[Users.lastName], it[Users.email], it[Users.password] ) }
                .firstOrNull()

        }
        /*val roles: ArrayList<IRole> = ArrayList()
        roles.add(Role("1", "buyer"))*/

        return user
    }

    override suspend fun findById(idUser: String): User? = transaction {
        Users.select { Users.idUser.eq(idUser) }
            .mapNotNull { User(it[Users.idUser], it[Users.firstName], it[Users.lastName], it[Users.email], it[Users.password] ) }
            .firstOrNull()
    }

}