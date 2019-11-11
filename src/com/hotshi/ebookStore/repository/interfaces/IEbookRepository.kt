package com.hotshi.com.hotshi.ebookStore.repository.interfaces

import com.hotshi.com.hotshi.ebookStore.models.EBook
import com.hotshi.com.hotshi.ebookStore.models.interfaces.IEBook

interface IEbookRepository {
    suspend fun upload(eBook: IEBook)
    suspend fun save(eBook: IEBook)
    suspend fun all(category: String): List<EBook>
    suspend fun findById(idEbook: String): EBook?
}