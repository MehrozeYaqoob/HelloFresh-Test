package com.hellofresh.task1

/* dependencies will be injected here */
data class Menu(val recipes: List<Recipe>, val subscription: Subscription, val config: Config) {

    private val selectedRecipesMap = mutableMapOf<Long, Boolean>()

    /* Returns an Immutable List of recipes, that are available for selection */
    fun getAvailableRecipes(includeAlreadySelected: Boolean = true): List<Recipe> {
        return if (includeAlreadySelected) {
            recipes
        } else {
            getUnSelectedRecipes()
        }
    }

    /* Returns an Immutable List of recipes, that are selected */
    fun getSelectedRecipes(): List<Recipe> {
        return recipes.filter { selectedRecipesMap.containsKey(it.id) }
    }

    /* Returns an Immutable List of recipes, that are not selected */
    fun getUnSelectedRecipes(): List<Recipe> {
        return recipes.filter { !selectedRecipesMap.containsKey(it.id) }
    }

    /* Returns an Immutable List of recipes(selected/unselected), filtered w.r.t tag */
    fun getAvailableRecipesByTag(tag: Tag): List<Recipe> {
        return getAvailableRecipes().filter { it.tags.contains(tag) }
    }

    /* Returns an Immutable List of unselected recipes, filtered w.r.t tag */
    fun getUnselectedRecipesByTag(tag: Tag): List<Recipe> {
        return getAvailableRecipes(includeAlreadySelected = false).filter { it.tags.contains(tag) }
    }

    /* Returns an Immutable List of selected recipes, filtered w.r.t tag*/
    fun getSelectedRecipesByTag(tag: Tag): List<Recipe> {
        return getSelectedRecipes().filter { it.tags.contains(tag) }
    }

    /* Returns true if recipe is selected successfully, false otherwise*/
    fun selectRecipe(id: Long): Boolean {
        if(getSelectedRecipesCount() == getSelectionThreshold()){ return false}
        val recipe = getAvailableRecipes(includeAlreadySelected = false).find { it.id == id }
        recipe?.let { selectedRecipesMap[it.id] = true }
        return recipe != null
    }

    /* Returns true if recipes are selected successfully, false if recipe threshold
    * for selected exceeds given configuration */
    fun selectRecipes(ids: List<Long>): Boolean {
        if (getSelectedRecipesCount() == getSelectionThreshold() || ids.count() > getSelectionThreshold()) {
            return false
        }
        val selectedRecipes = getAvailableRecipes(includeAlreadySelected = false).filter { ids.contains(it.id) }
        for (recipe in selectedRecipes) {
            selectedRecipesMap[recipe.id] = true
        }
        return selectedRecipes.count() > 0
    }

    /* Returns true if recipe is unselected successfully, false otherwise*/
    fun unSelectRecipe(id: Long): Boolean {
        val recipe = getSelectedRecipes().find { it.id == id }
        recipe?.let { selectedRecipesMap.remove(it.id) }
        return recipe != null
    }

    /* Returns true if recipes are unselected successfully, false if either
    * no recipe is unselected */
    fun unSelectRecipes(ids: List<Long>): Boolean {
        if (ids.count() > getSelectedRecipesCount()) {
            return false
        }
        val recipesToUnselect = getSelectedRecipes().filter { ids.contains(it.id) }
        for (recipe in recipesToUnselect) {
            selectedRecipesMap.remove(recipe.id)
        }
        return recipesToUnselect.count() > 0
    }

    /* Return the count of recipes selected */
    fun getSelectedRecipesCount(): Int {
        return selectedRecipesMap.count()
    }

    /* Return threshold for selecting recipes */
    fun getSelectionThreshold(): Int {
        return if (subscription.isForFamily) {
            config.familyThreshold
        } else {
            config.selectionThreshold
        }
    }
}
