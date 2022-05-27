package com.hellofresh.task2.domain.mapper

import com.hellofresh.task2.common.Mapper
import com.hellofresh.task2.presentation.model.RecipeUiModel
import com.hellofresh.task2.data.model.RecipeApiModel

class RecipeDomainMapper : Mapper<RecipeApiModel, RecipeUiModel> {

    override fun map(from: RecipeApiModel): RecipeUiModel {
        return RecipeUiModel(
            calories = from.calories,
            carbos = from.carbos,
            description = from.description,
            fats = from.fats,
            headline = from.headline,
            id = from.id,
            image = from.image,
            name = from.name,
            proteins = from.proteins,
            thumb = from.thumb,
            time = from.time,
            difficulty = from.difficulty,
        )
    }
}
