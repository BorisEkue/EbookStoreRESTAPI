package com.hotshi.com.hotshi.ebookStore.models.payment

import com.hotshi.com.hotshi.ebookStore.models.interfaces.payment.IMobileMoney

data class MobileMoney(
    override val number: String
) : IMobileMoney