package com.hotshi.com.hotshi.ebookStore.repository.payment

import com.hotshi.com.hotshi.ebookStore.models.interfaces.payment.IMobileMoney
import com.hotshi.com.hotshi.ebookStore.repository.interfaces.payment.IMobileMoneyRepository

class MobileMoneyRepository: IMobileMoneyRepository {
    override suspend fun createMobileMoneyAccount(mobileMoney: IMobileMoney) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun findAccoountByNumber(number: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getBalance(mobileMoney: IMobileMoney) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun chargeAccount(mobileMoney: IMobileMoney, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}