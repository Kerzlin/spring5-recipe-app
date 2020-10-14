package kerzlin.spring5recipeapp.services;

import kerzlin.spring5recipeapp.commands.RecipeCommand;
import kerzlin.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
