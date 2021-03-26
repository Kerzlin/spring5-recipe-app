package kerzlin.spring5recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

  Category category;

  public CategoryTest() {
  }

  @Before
  public void setUp(){
    category = new Category();
  }

  @Test
  public void getId() throws Exception {
    Long idValue = 4L;

    category.setId(idValue);

    assertEquals(idValue, category.getId());
  }

  @Test
  public void getDescription() throws Exception {
    String desc = "Description";
    category.setDescription(desc);
    assertEquals(desc, category.getDescription());
  }

  @Test
  public void getRecipes() throws Exception {
    Recipe recipe = new Recipe();
    Set<Recipe> recipes = new HashSet<>();
    recipes.add(recipe);
    category.setRecipes(recipes);
    assertEquals(recipes, category.getRecipes());
  }

}
