package com.hellofresh.task2.domain.repository

import com.hellofresh.task2.presentation.model.RecipeUiModel

interface RestaurantRepository {
    suspend fun fetchRecipes(): List<RecipeUiModel>
}
