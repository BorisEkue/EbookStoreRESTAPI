package com.hotshi.com.hotshi.ebookStore.repository.payment

import com.hotshi.com.hotshi.ebookStore.models.interfaces.payment.ICard
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.payment.ICardRepository

class CardRepository : ICardRepository {
    override suspend fun createCard(card: ICard) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun findCardByNUmber(number: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun chargeCard(card: ICard, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getBalance(card: ICard) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}