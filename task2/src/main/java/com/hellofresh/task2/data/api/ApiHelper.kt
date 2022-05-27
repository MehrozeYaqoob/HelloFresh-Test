package com.hellofresh.task2.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun fetchRecipes() = apiService.fetchRecipes()
}
