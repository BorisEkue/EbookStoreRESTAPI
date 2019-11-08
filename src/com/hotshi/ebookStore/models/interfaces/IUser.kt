package com.hotshi.com.hotshi.ebookStore.models.interfaces

interface IUser {
    val idUser: String
    val firstName: String
    val lastName: String
    val email: String
    val password: String
    val roles: ArrayList<IRole>
}