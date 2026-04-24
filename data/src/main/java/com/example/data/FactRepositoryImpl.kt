package com.example.data

import com.example.domain.Fact
import com.example.domain.FactRepository
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val api: FactApi
) : FactRepository {
    override suspend fun getRandomFact(): Result<Fact> {
        return try {
            val response = api.getRandomFact()
            Result.success(Fact(text = response.fact))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}