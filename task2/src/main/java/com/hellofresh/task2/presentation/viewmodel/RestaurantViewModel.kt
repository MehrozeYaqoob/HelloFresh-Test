package com.hellofresh.task2.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellofresh.task2.presentation.model.RecipeUiModel
import com.hellofresh.task2.domain.usecase.RestaurantUseCase
import com.hellofresh.task2.common.exceptionHandler
import com.hellofresh.task2.utils.Resource
import kotlinx.coroutines.launch

class RestaurantViewModel(
    private val restaurantUseCase: RestaurantUseCase,
) : ViewModel() {
    private val recipeListLiveData = MutableLiveData<Resource<List<RecipeUiModel>>>()
    val recipeListLiveDataViewState: LiveData<Resource<List<RecipeUiModel>>>
        get() = recipeListLiveData

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        recipeListLiveData.value = Resource.loading(null)

        val errorHandler = viewModelScope.exceptionHandler {
            handleRecipeListError(it)
        }

        viewModelScope.launch(errorHandler) {
            handleOnSuccess(restaurantUseCase.run(Unit))
        }
    }

    private fun handleOnSuccess(recipes: List<RecipeUiModel>) {
        recipeListLiveData.value = Resource.success(recipes)
    }

    private fun handleRecipeListError(throwable: Throwable? = null) {
        recipeListLiveData.value = Resource.error(throwable?.localizedMessage, null)
    }
}
