package com.example.domain

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetRandomFactUseCaseTest {
    @Test
    fun testInvoke() = runBlocking {
        // Данные, которые мы ожидаем
        val expected = Fact("AI can build apps fast")

        // Создаем фейковый репозиторий прямо в тесте
        val repo = object : FactRepository {
            override suspend fun getRandomFact() = Result.success(expected)
        }

        val useCase = GetRandomFactUseCase(repo)
        val result = useCase.invoke()

        // Проверяем, что UseCase вернул ровно то, что мы дали репозиторию
        assertEquals(expected, result.getOrNull())
    }
}