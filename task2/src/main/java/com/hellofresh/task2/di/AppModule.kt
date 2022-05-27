package com.hellofresh.task2.di

import com.hellofresh.task2.common.ApiClient
import com.hellofresh.task2.data.api.ApiHelper
import com.hellofresh.task2.domain.mapper.RecipeDomainMapper
import com.hellofresh.task2.domain.repository.RestaurantRepositoryImpl
import com.hellofresh.task2.domain.usecase.RestaurantUseCase
import com.hellofresh.task2.presentation.viewmodel.ViewModelFactory
import org.koin.dsl.module

val appModule = module {

    single {
        RecipeDomainMapper()
    }

    single {
        ApiHelper(ApiClient.apiService)
    }

    single {
        RestaurantRepositoryImpl(get(), get())
    }

    single {
        RestaurantUseCase(get<RestaurantRepositoryImpl>())
    }

    single {
        ViewModelFactory(get())
    }
}


