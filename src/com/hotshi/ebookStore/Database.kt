package com.hotshi.com.hotshi.ebookStore

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

fun initDatabase() {
    val config = HikariConfig("/hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)
}