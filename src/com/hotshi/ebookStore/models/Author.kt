package com.hotshi.com.hotshi.ebookStore.models

import com.hotshi.com.hotshi.ebookStore.models.interfaces.IAuthor
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IEBook

data class Author(
    override val idAuthor: String,
    override val firstName: String,
    override val lastName: String,
    override val ebooks: ArrayList<IEBook>
) : IAuthor