package com.hellofresh.task2.domain.usecase

import com.hellofresh.task2.presentation.model.RecipeUiModel
import com.hellofresh.task2.domain.repository.RestaurantRepository

class RestaurantUseCase(
    private val restaurantRepository: RestaurantRepository,
) : CoroutineUseCase<Unit, List<RecipeUiModel>> {

    override suspend fun run(params: Unit): List<RecipeUiModel> {
        return restaurantRepository.fetchRecipes()
    }
}
