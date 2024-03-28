package com.example.db.db

interface DatabaseTransactionRunner {
    suspend operator fun <T>invoke(block: () -> T): T
}