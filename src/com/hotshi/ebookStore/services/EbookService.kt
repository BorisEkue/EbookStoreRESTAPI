package com.hotshi.com.hotshi.ebookStore.services

import com.hotshi.com.hotshi.ebookStore.models.EBook
import com.hotshi.com.hotshi.ebookStore.models.User
import com.hotshi.com.hotshi.ebookStore.repository.EBookRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IEbookRepository
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.IUserRepository

class EbookService(private val eBookRepository: IEbookRepository, private val userRepository: IUserRepository) {
    suspend fun save(ebook: EBook, user: User) {

    }
}