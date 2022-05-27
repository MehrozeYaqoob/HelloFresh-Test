package com.hellofresh.task1

import java.util.*

internal object  Task1TestData {

    fun provideConfig() = Config
    fun provideTag() = listOf(Tag(1, "deal"))
    fun provideTags() = listOf(Tag(1, "hot"),Tag(2, "low-calorie"),Tag(3, "popular"))
    fun provideRecipe() = Recipe(1,"Arabic Shawarma", provideTags())
    fun provideRecipes() = listOf(
        Recipe(1,"Arabic Shawarma", provideTags()),
        Recipe(2,"Burger Hub", provideTag()),
        Recipe(3,"Subway", provideTags()),
        Recipe(4,"But Sweets", provideTag()),
        Recipe(5,"Chinese Delight", provideTags()))
    fun provideSubscription() = Subscription(1, Date(),false)
    fun provideSubscriptionForFamily() = Subscription(1, Date(),true)
}
