package com.hellofresh.task2.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hellofresh.task2.databinding.ItemDateLayoutBinding
import com.hellofresh.task2.presentation.model.DateUiModel
import kotlinx.android.synthetic.main.item_date_layout.view.*

class DateViewHolder(private val binding: ItemDateLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dateUiModel: DateUiModel) {
        binding.root.apply {
            dateTextView.text = dateUiModel.date
        }
    }
}
