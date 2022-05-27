package com.hellofresh.task2.domain.repository

import com.hellofresh.task2.data.api.ApiHelper
import com.hellofresh.task2.domain.mapper.RecipeDomainMapper
import com.hellofresh.task2.presentation.model.RecipeUiModel

class RestaurantRepositoryImpl(
    private val apiHelper: ApiHelper,
    private val recipeDomainMapper: RecipeDomainMapper,
) : RestaurantRepository {
    override suspend fun fetchRecipes(): List<RecipeUiModel> {
        return apiHelper.fetchRecipes().map { recipeDomainMapper.map(it) }
    }
}
