package com.hellofresh.task2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellofresh.task2.domain.usecase.RestaurantUseCase

class ViewModelFactory(private val restaurantUseCase: RestaurantUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            return RestaurantViewModel(restaurantUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}
