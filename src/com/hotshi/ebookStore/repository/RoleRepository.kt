package com.hotshi.com.hotshi.ebookStore.repository

import com.hotshi.com.hotshi.ebookStore.dao.Roles
import com.hotshi.com.hotshi.ebookStore.dao.UserRoles
import com.hotshi.com.hotshi.ebookStore.models.Role
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IRole
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IRoleRepository
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.transaction

class RoleRepository : IRoleRepository {
    override suspend fun getUserRoles(idUser: String): List<Role> {

         return transaction {
            (Roles innerJoin UserRoles ).slice(Roles.idRole, Roles.name)
                .select { UserRoles.idUser.eq(idUser) }
                .mapNotNull { Role(idRole = it[Roles.idRole], name = it[Roles.name]) }


        }
    }
}