package com.hellofresh.task1

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class MenuTest {

    private val recipes by lazy {
        Task1TestData.provideRecipes()
    }
    private val menu by lazy {
        Menu(recipes, Task1TestData.provideSubscription(), Task1TestData.provideConfig())
    }
    private val menuForFamily by lazy {
        Menu(recipes, Task1TestData.provideSubscriptionForFamily(), Task1TestData.provideConfig())
    }

    @Test
    fun `test Menu data model`() {
        assertEquals(recipes, menu.recipes)
        assertNotEquals(Task1TestData.provideSubscription(), menu.subscription)
        assertEquals(Task1TestData.provideConfig(), menu.config)
    }

    @Test
    fun `test getAvailableRecipes without already selected`() {
        menu.selectRecipe(1)
        val list = menu.getAvailableRecipes(false)
        assertEquals(list.size, recipes.size - 1)
        assertEquals(list[0], recipes[1])
        assertEquals(list[list.size - 1].title, recipes[recipes.size - 1].title)
    }

    @Test
    fun `test getAvailableRecipes including already selected`() {
        menu.selectRecipe(1)
        val list = menu.getAvailableRecipes()
        assertEquals(list.size, recipes.size)
        assertEquals(list[0], recipes[0])
        assertEquals(list[list.size - 1].title, recipes[recipes.size - 1].title)
    }

    @Test
    fun `test getSelectedRecipes after adding 1 recipe`() {
        menu.selectRecipe(1)
        val list = menu.getSelectedRecipes()
        assertEquals(1, list.size)
        assertEquals(Task1TestData.provideRecipe(), list[0])
        assertEquals(Task1TestData.provideRecipe().tags, list[0].tags)
    }

    @Test
    fun `test getSelectedRecipes after adding many recipe`() {
        menu.selectRecipes(listOf(1, 2, 3))
        val list = menu.getSelectedRecipes()
        assertEquals(3, list.size)
        assertEquals(Task1TestData.provideRecipe(), list[0])
        assertEquals(Task1TestData.provideRecipe().tags, list[0].tags)
    }

    @Test
    fun `test getUnSelectedRecipes after adding 1 recipe`() {
        menu.selectRecipe(2)
        val list = menu.getUnSelectedRecipes()
        assertEquals(4, list.size)
        assertEquals(Task1TestData.provideRecipe(), list[0])
        assertEquals(Task1TestData.provideRecipe().tags, list[0].tags)
    }

    @Test
    fun `test getUnSelectedRecipes after adding many recipe with family subscription`() {
        val isSelectionSuccessful = menuForFamily.selectRecipes(listOf(1, 2, 3, 4))
        val list = menuForFamily.getUnSelectedRecipes()
        assertEquals(1, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals("Chinese Delight", list[list.size - 1].title)
        assertEquals(Task1TestData.provideTags(), list[list.size - 1].tags)
    }

    @Test
    fun `test getAvailableRecipesByTag after adding many recipe with family subscription`() {
        val isSelectionSuccessful = menuForFamily.selectRecipes(listOf(1, 2, 3, 4))
        val list = menuForFamily.getAvailableRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(2, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals("But Sweets", list[list.size - 1].title)
        assertEquals(Task1TestData.provideTag(), list[list.size - 1].tags)
    }

    @Test
    fun `test getAvailableRecipesByTag after adding many recipe without family subscription`() {
        val isSelectionSuccessful = menu.selectRecipes(listOf(1, 2, 3))
        val list = menu.getAvailableRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(2, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals("But Sweets", list[list.size - 1].title)
        assertEquals(Task1TestData.provideTag(), list[list.size - 1].tags)
    }

    @Test
    fun `test getUnselectedRecipesByTag after adding many recipe without family subscription`() {
        val isSelectionSuccessful = menu.selectRecipes(listOf(1, 2, 3))
        val list = menu.getUnselectedRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(1, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals("But Sweets", list[list.size - 1].title)
        assertEquals(Task1TestData.provideTag(), list[list.size - 1].tags)
    }

    @Test
    fun `test getUnselectedRecipesByTag after adding many recipe with family subscription`() {
        val isSelectionSuccessful = menuForFamily.selectRecipes(listOf(1, 2, 3, 4))
        val list = menuForFamily.getUnselectedRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(0, list.size)
        assertEquals(true, isSelectionSuccessful)
    }

    @Test
    fun `test getSelectedRecipesByTag after adding many recipe with family subscription`() {
        val isSelectionSuccessful = menuForFamily.selectRecipes(listOf(2, 3, 4, 5))
        val list = menuForFamily.getSelectedRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(2, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals(4, list[list.size - 1].id)
        assertNotEquals(Task1TestData.provideRecipe().title, list[list.size - 1].title)
    }

    @Test
    fun `test getSelectedRecipesByTag after adding 1 recipe without family subscription`() {
        val isSelectionSuccessful = menu.selectRecipes(listOf(4))
        val list = menu.getSelectedRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(1, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals(4, list[list.size - 1].id)
        assertNotEquals(Task1TestData.provideRecipe().tags, list[list.size - 1].tags)
    }

    @Test
    fun `test getSelectedRecipesByTag after adding 1 recipe with family subscription`() {
        val isSelectionSuccessful = menuForFamily.selectRecipes(listOf(4))
        val list = menuForFamily.getSelectedRecipesByTag(Task1TestData.provideTag()[0])
        assertEquals(1, list.size)
        assertEquals(true, isSelectionSuccessful)
        assertEquals(4, list[list.size - 1].id)
        assertNotEquals(Task1TestData.provideRecipe().tags, list[list.size - 1].tags)
    }

    @Test
    fun `test selectRecipe after adding 1 recipe with family subscription`() {
        val isSelected = menuForFamily.selectRecipe(1)
        val list = menuForFamily.getSelectedRecipes()
        assertEquals(1, list.size)
        assertEquals(true, isSelected)
    }

    @Test
    fun `test selectRecipe after adding 1 recipe without family subscription`() {
        val isSelected = menu.selectRecipe(5)
        val list = menu.getSelectedRecipes()
        assertEquals(1, list.size)
        assertEquals(true, isSelected)
    }

    @Test
    fun `test selectRecipe after adding 1 recipe without family subscription with invalid id`() {
        val isSelected = menu.selectRecipe(0)
        val list = menu.getSelectedRecipes()
        assertEquals(0, list.size)
        assertEquals(false, isSelected)
    }

    @Test
    fun `test selectRecipes after adding 4 recipe without family subscription`() {
        val isSelected = menu.selectRecipes(listOf(1, 2, 3, 4))
        assertEquals(false, isSelected)
    }

    @Test
    fun `test selectRecipes after adding 6 recipe with family subscription`() {
        val isSelected = menuForFamily.selectRecipes(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(false, isSelected)
    }

    @Test
    fun `test unSelectRecipe without adding any recipe with family subscription`() {
        val isUnselected = menuForFamily.unSelectRecipe(1)
        assertEquals(false, isUnselected)
    }

    @Test
    fun `test unSelectRecipe after adding 1 recipe with family subscription`() {
        val isSelected = menuForFamily.selectRecipe(1)
        val isUnselected = menuForFamily.unSelectRecipe(1)
        assertEquals(true, isUnselected)
        assertEquals(isSelected, isUnselected)
    }

    @Test
    fun `test unSelectRecipe without adding any recipe, without family subscription, using available recipes`() {
        val isUnselected = menu.unSelectRecipe(5)
        // Since nothing is selected, so unselected is same as Available
        val list = menu.getUnSelectedRecipes()
        assertEquals(5, list.size)
        assertEquals(false, isUnselected)
    }

    @Test
    fun `test unSelectRecipe after adding 1 recipe without family subscription with invalid id`() {
        val isSelect = menu.selectRecipe(1)
        val isUnselected = menu.unSelectRecipe(0)
        assertEquals(false, isUnselected)
        assertNotEquals(isUnselected, isSelect)
    }

    @Test
    fun `test unSelectRecipes after adding many recipes without family subscription with invalid ids`() {
        val isSelect = menu.selectRecipes(listOf(1, 2, 3))
        val isUnselected = menu.unSelectRecipes(listOf(0, 4))
        assertEquals(false, isUnselected)
        assertNotEquals(isUnselected, isSelect)
    }

    @Test
    fun `test unSelectRecipes without adding any recipe, without family subscription, using available recipes`() {
        val isUnselected = menu.unSelectRecipes(listOf(5))
        // Since nothing is selected, so unselected is same as Available
        val list = menu.getUnSelectedRecipes()
        assertEquals(5, list.size)
        assertEquals(false, isUnselected)
    }

    @Test
    fun `test unSelectRecipes after adding many recipes without family subscription with valid ids`() {
        val isSelect = menu.selectRecipes(listOf(1, 2, 3))
        val isUnselected = menu.unSelectRecipes(listOf(2, 3))
        val list = menu.getSelectedRecipes()
        assertEquals(true, isUnselected)
        assertEquals(isUnselected, isSelect)
        assertEquals(1, list.size)
    }

    @Test
    fun `test getSelectedRecipesCount after adding many recipes without family subscription`() {
        val isSelect = menu.selectRecipes(listOf(1, 2, 3))
        val count = menu.getSelectedRecipesCount()
        assertEquals(true, isSelect)
        assertEquals(3, count)
    }

    @Test
    fun `test getSelectedRecipesCount after adding 1 recipe without family subscription, with invalid id`() {
        val isSelect = menu.selectRecipe(0)
        val count = menu.getSelectedRecipesCount()
        assertEquals(false, isSelect)
        assertEquals(0, count)
    }

    @Test
    fun `test getSelectedRecipesCount after adding many recipe with family subscription, with invalid id`() {
        val isSelect = menu.selectRecipes(listOf(0, 6, 7))
        val count = menu.getSelectedRecipesCount()
        assertEquals(false, isSelect)
        assertEquals(0, count)
    }

    @Test
    fun `test getSelectedRecipesCount after adding many recipe with family subscription, with invalid & valid id`() {
        val isSelect = menu.selectRecipes(listOf(1, 6, 7))
        val count = menu.getSelectedRecipesCount()
        assertEquals(true, isSelect)
        assertEquals(1, count)
    }

    @Test
    fun `test getSelectionThreshold without Family Subscription`() {
        val threshold = menu.getSelectionThreshold()
        assertEquals(menu.config.selectionThreshold, threshold)
    }

    @Test
    fun `test getSelectionThreshold with Family Subscription`() {
        val threshold = menuForFamily.getSelectionThreshold()
        assertEquals(menuForFamily.config.familyThreshold, threshold)
    }
}
