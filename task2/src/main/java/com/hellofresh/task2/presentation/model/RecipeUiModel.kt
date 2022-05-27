package com.hellofresh.task2.presentation.model

import com.hellofresh.task2.utils.ViewType

data class RecipeUiModel(
    val calories: String,
    val carbos: String,
    val description: String,
    val difficulty: Int,
    val fats: String,
    val headline: String,
    val image: String,
    val name: String,
    val proteins: String,
    val thumb: String,
    val time: String,
    override val id: String,
) : BaseUiModel {
    override fun getItemViewType(): ViewType {
        return ViewType.RECIPES
    }
}
