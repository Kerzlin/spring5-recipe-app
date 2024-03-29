package kerzlin.spring5recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Recipe implements Comparable<Recipe> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private Integer prepTime;
  private Integer cookTime;
  private Integer servings;
  private String source;
  private String url;
  @Lob
  private String directions;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // target property on igridient class
  private Set<Ingredient> ingredients = new HashSet<>();
  @Lob
  private Byte[] image;
  @Enumerated(value = EnumType.STRING)
  private Difficulty difficulty;

  @OneToOne(cascade = CascadeType.ALL)
  private Notes notes;

  @ManyToMany
  @JoinTable(name="recipe_category", joinColumns = @JoinColumn(name= "recipe_id"),
          inverseJoinColumns = @JoinColumn(name="category_id"))
  private Set<Category> categories = new HashSet<>();

  public void setNotes(Notes notes) {
    if (notes != null) {
      this.notes = notes;
      notes.setRecipe(this);
    }
  }

  public Recipe addIngredient(Ingredient ingredient) {
    ingredient.setRecipe(this);
    this.ingredients.add(ingredient);
    return this;
  }

  @Override
  public int compareTo(Recipe recipe) {
    return this.getDescription().compareTo(recipe.getDescription());
  }

}
