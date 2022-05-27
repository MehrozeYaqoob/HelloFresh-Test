# Task 1

### Engineering Comments

- Used hashmap for keeping track of selected recipes
- Available recipes can exclude recipes that are already selected, include otherwise
- Subscription & Selection threshold values will be injected as dependencies
- Boolean is returned as part of selection and un-selection of recipes
- Immutable lists are returned when get functions are called for recipes
- For selectRecipes method, If selected ids are more then available recipes, then false is returned
- Case not handled when selected ids include both valid & invalid id (within threshold bound) for selectRecipes method.
  same for unSelecteRecipes method
- Case handled when selected id include any invalid id for selectRecipe methods, same for unSelectRecipe method


### Decision Points

- getUnSelectedRecipes | getUnselectedRecipesByTag | getSelectedRecipesByTag are included as bonus addition
- getAvailableRecipes can include recipes that are not selected.
- getUnselectedRecipesByTag | getSelectedRecipesByTag are included as bonus addition 
- Unselected recipes are removed from hashmap. So hashmap will only record recipes that are selected
- Tag is a model class and not an enum because enums are not dynamic, tags are in this case
- I pass id in select/unselect recipes and not the complete object to avoid parcelisation of model class 
