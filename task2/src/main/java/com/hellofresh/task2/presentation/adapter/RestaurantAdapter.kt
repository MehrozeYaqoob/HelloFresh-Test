package com.hellofresh.task2.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hellofresh.task2.databinding.ItemDateLayoutBinding
import com.hellofresh.task2.databinding.ItemRecipeLayoutBinding
import com.hellofresh.task2.presentation.model.BaseUiModel
import com.hellofresh.task2.presentation.model.DateUiModel
import com.hellofresh.task2.presentation.model.RecipeUiModel
import com.hellofresh.task2.presentation.viewholder.DateViewHolder
import com.hellofresh.task2.presentation.viewholder.RecipeViewHolder
import com.hellofresh.task2.utils.ViewType

class RestaurantAdapter(private val itemList: ArrayList<BaseUiModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ViewType.DATE.value) {
            DateViewHolder(ItemDateLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            RecipeViewHolder(ItemRecipeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getItemViewType().value
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ViewType.DATE.value -> {
                (holder as DateViewHolder).bind(itemList[position] as DateUiModel)
            }
            else -> {
                (holder as RecipeViewHolder).bind(itemList[position] as RecipeUiModel)
            }
        }
    }

    fun addRecipes(recipesItem: List<BaseUiModel>) {
        val dateItem = this.itemList[0]
        val result = createDiffResult(this.itemList, recipesItem)
        this.itemList.clear()
        this.itemList.add(dateItem)
        this.itemList.addAll(recipesItem)
        result.dispatchUpdatesTo(this)
    }

    private fun createDiffResult(oldList: List<BaseUiModel>, newList: List<BaseUiModel>): DiffUtil.DiffResult {
        return DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].id == newList[newItemPosition].id && oldList[oldItemPosition].id == newList[newItemPosition].id
            }

            override fun getOldListSize(): Int {
                return oldList.size
            }

            override fun getNewListSize(): Int {
                return newList.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }
        })
    }

}
