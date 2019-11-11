package com.hotshi.com.hotshi.ebookStore.models.interfaces.payment

interface ICard : IAccount {
    val number: String
    val cvc: String
    val expiryMonth: Int
    val expiryYear: Int
}