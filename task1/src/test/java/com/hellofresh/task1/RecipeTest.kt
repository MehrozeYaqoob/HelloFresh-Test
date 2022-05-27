package com.hellofresh.task1

import junit.framework.TestCase
import org.junit.Test
import kotlin.test.assertNotEquals

class RecipeTest : TestCase(){

    @Test
    fun `test id of recipe`(){
        val recipe = Task1TestData.provideRecipe()
        assertEquals(1, recipe.id)
    }

    @Test
    fun `test title of recipe`(){
        val recipe = Task1TestData.provideRecipe()
        assertEquals("Arabic Shawarma", recipe.title)
    }

    @Test
    fun `test tag list of recipe`(){
        val recipe = Task1TestData.provideRecipe()
        assertNotEquals(Task1TestData.provideTag(), recipe.tags)
    }
}
