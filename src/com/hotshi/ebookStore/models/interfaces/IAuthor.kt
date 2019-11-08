package com.hotshi.com.hotshi.ebookStore.models.interfaces

interface IAuthor {
    val idAuthor: String
    val firstName: String
    val lastName: String
    val ebooks: ArrayList<IEBook>
}