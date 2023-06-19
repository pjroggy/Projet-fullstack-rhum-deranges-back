package Pjcheckpoint3.rhumDeranges.recipe;

import Pjcheckpoint3.rhumDeranges.ingredient.Ingredient;
import Pjcheckpoint3.rhumDeranges.rhum.Rhum;
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
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("recipeList")
    private Set<Ingredient> ingredientList = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("recipeList")
    private Rhum rhum;

    private String dateOfCreation;
    private Float price;
}
