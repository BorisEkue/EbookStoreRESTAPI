package com.hotshi.com.hotshi.ebookStore.repository.interfaces.payment

import com.hotshi.com.hotshi.ebookStore.models.interfaces.payment.IMobileMoney

interface IMobileMoneyRepository {
    suspend fun createMobileMoneyAccount(mobileMoney: IMobileMoney)
    suspend fun findAccoountByNumber(number: String)
    suspend fun chargeAccount(mobileMoney: IMobileMoney, amount: Int)
    suspend fun getBalance(mobileMoney: IMobileMoney)
}