package com.hellofresh.task2.domain.usecase

interface CoroutineUseCase<Params, Result> {
    suspend fun run(params: Params): Result
}
