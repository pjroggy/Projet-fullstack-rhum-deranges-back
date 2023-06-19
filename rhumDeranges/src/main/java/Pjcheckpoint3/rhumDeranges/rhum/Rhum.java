package Pjcheckpoint3.rhumDeranges.rhum;

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
public class Rhum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String origin;
    private Float alcoholDegree;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "rhum_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"rhum", "ingredientList", "dateOfCreation", "price"})
    private Set<Recipe> recipeList = new HashSet<>();

}