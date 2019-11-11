package com.hotshi.com.hotshi.ebookStore.repository.interfaces.payment

import com.hotshi.com.hotshi.ebookStore.models.interfaces.payment.ICard

interface ICardRepository  {
    suspend fun createCard(card: ICard)
    suspend fun findCardByNUmber(number: String)
    suspend fun chargeCard(card: ICard, amount: Int)
    suspend fun getBalance(card: ICard)
}