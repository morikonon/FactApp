package com.example.data

import retrofit2.http.GET

data class FactDto(
    val fact: String // API возвращает JSON с полем "fact"
)

interface FactApi {
    @GET("fact")
    suspend fun getRandomFact(): FactDto
}