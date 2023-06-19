package Pjcheckpoint3.rhumDeranges.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository repository;

    public List<Ingredient> getAll() {
        return repository.findAll();
    }

    public Ingredient getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Ingredient create(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public Ingredient updateStore(Ingredient ingredient, Long id) {
        Ingredient foundIngredient = repository.getById(id);
        foundIngredient.setName(ingredient.getName());
        foundIngredient.setQuantity(ingredient.getQuantity());
        foundIngredient.setRecipeList(ingredient.getRecipeList());

        return repository.save(foundIngredient);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

