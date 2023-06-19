package Pjcheckpoint3.rhumDeranges.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;

    public List<Recipe> getAll() {
        return repository.findAll();
    }

    public Recipe getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Recipe create(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe updateStore(Recipe recipe, Long id) {
        Recipe foundRecipe = repository.getById(id);
        foundRecipe.setName(recipe.getName());
        foundRecipe.setIngredientList(recipe.getIngredientList());
        foundRecipe.setRhum(recipe.getRhum());
        foundRecipe.setDateOfCreation(recipe.getDateOfCreation());
        foundRecipe.setPrice(recipe.getPrice());

        return repository.save(foundRecipe);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
