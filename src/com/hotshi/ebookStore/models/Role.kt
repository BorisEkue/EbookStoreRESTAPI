package com.hotshi.com.hotshi.ebookStore.models

import com.hotshi.com.hotshi.ebookStore.models.interfaces.IRole

data class Role(
    override val idRole: String,
    override val name: String
) : IRole