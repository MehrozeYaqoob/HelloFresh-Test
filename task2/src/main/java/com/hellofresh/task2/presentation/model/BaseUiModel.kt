package com.hellofresh.task2.presentation.model

import com.hellofresh.task2.utils.ViewType

interface BaseUiModel {
    val id: String
    fun getItemViewType(): ViewType
}
