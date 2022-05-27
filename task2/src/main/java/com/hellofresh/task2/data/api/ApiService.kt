package com.hellofresh.task2.data.api

import com.hellofresh.task2.data.model.RecipeApiModel
import retrofit2.http.GET

interface ApiService {
    @GET("android-test/recipes.json")
    suspend fun fetchRecipes(): List<RecipeApiModel>
}

