package com.example.domain

interface FactRepository {
    suspend fun getRandomFact(): Result<Fact>
}