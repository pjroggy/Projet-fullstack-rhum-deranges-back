package Pjcheckpoint3.rhumDeranges.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;

    @GetMapping("/all")
    public List<Ingredient> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Ingredient getStoreById(@PathVariable("id") Long id) {

        return service.getById(id);
    }

    @PostMapping("/add")
    public Ingredient create(@RequestBody Ingredient ingredient) {
        return service.create(ingredient);
    }

    @PutMapping("/update/{id}")
    public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable("id") Long id) {
        return service.updateStore(ingredient, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}