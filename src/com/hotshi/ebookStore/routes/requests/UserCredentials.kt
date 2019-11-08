package com.hotshi.com.hotshi.ebookStore.routes.requests

import com.fasterxml.jackson.annotation.JsonProperty

data class UserCredentials(
    @JsonProperty("email")
    val email: String,

    @JsonProperty("password")
    val password: String
)