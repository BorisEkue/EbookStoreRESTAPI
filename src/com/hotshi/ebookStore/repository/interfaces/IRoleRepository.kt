package com.hotshi.com.hotshi.ebookStore.repository.interfaces

import com.hotshi.com.hotshi.ebookStore.models.Role
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IRole

interface IRoleRepository {
    suspend fun getUserRoles(idUser: String): List<Role>
}