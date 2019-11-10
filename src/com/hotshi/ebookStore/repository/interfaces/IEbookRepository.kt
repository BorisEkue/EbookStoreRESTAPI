package com.hotshi.com.hotshi.ebookStore.repository.interfaces

import com.hotshi.com.hotshi.ebookStore.models.EBook
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IEBook

interface IEbookRepository {
    suspend fun upload(eBook: IEBook)
}