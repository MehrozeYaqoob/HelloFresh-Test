package com.hellofresh.task2.presentation.model

import com.hellofresh.task2.utils.ViewType

data class DateUiModel(val date: String) : BaseUiModel {
    override val id: String
        get() = "0"

    override fun getItemViewType() = ViewType.DATE
}
