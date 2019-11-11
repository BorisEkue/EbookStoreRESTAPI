package com.hotshi.com.hotshi.ebookStore.models.payment

import com.hotshi.com.hotshi.ebookStore.models.interfaces.payment.ICard

data class Card(
    override val number: String,
    override val cvc: String,
    override val expiryMonth: Int,
    override val expiryYear: Int
) : ICard {
    fun isExpired() = false
}