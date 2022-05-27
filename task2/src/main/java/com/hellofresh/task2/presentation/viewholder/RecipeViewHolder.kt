package com.hellofresh.task2.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellofresh.task2.databinding.ItemRecipeLayoutBinding
import com.hellofresh.task2.presentation.model.RecipeUiModel
import kotlinx.android.synthetic.main.item_recipe_layout.view.*

class RecipeViewHolder(private val binding: ItemRecipeLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: RecipeUiModel) {
        binding.root.apply {
            recipeNameTextView.text = recipe.name
            headlineTextView.text = recipe.headline
            proteinsValueTextView.text = recipe.proteins
            calorieValueTextView.text = recipe.calories
            timeTextView.text = recipe.time
            Glide.with(recipesImage.context)
                .load(recipe.image)
                .into(recipesImage)
        }
    }
}
