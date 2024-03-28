package com.example.legacy.mappers

fun interface Mapper<F, T> {
    suspend fun map(from: F): T
}