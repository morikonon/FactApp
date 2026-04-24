package com.example.domain

import javax.inject.Inject

class GetRandomFactUseCase @Inject constructor(
    private val repository: FactRepository
) {
    suspend operator fun invoke(): Result<Fact> {
        return repository.getRandomFact()
    }
}