package Pjcheckpoint3.rhumDeranges.ingredient;

import Pjcheckpoint3.rhumDeranges.recipe.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer quantity;

    @ManyToMany(mappedBy = "ingredientList")
    @JsonIgnoreProperties("ingredientList")
    private Set<Recipe> recipeList = new HashSet<>();

}