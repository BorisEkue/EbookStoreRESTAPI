package com.hotshi.com.hotshi.ebookStore.models

import com.hotshi.com.hotshi.ebookStore.models.interfaces.IRole
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IUser

data class User(
    override val idUser: String,
    override val firstName: String,
    override val lastName: String,
    override val email: String,
    override val password: String,
    override var roles: List<IRole>? = null
) : IUser