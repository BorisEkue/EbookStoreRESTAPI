package com.hotshi.com.hotshi.ebookStore.dao

import org.jetbrains.exposed.sql.Table

object UserRoles: Table("user_roles") {
    val idRole = varchar("id_role", 50).primaryKey() references Roles.idRole
    val idUser = varchar("id_user", 50).primaryKey() references Users.idUser
    val createdAt = datetime("created_at")
}