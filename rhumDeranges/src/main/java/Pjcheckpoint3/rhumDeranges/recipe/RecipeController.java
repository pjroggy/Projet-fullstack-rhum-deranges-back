package Pjcheckpoint3.rhumDeranges.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService service;

    @GetMapping("/all")
    public List<Recipe> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Recipe getStoreById(@PathVariable("id") Long id) {

        return service.getById(id);
    }

    @PostMapping("/add")
    public Recipe create(@RequestBody Recipe recipe) {
        return service.create(recipe);
    }

    @PutMapping("/update/{id}")
    public Recipe update(@RequestBody Recipe recipe, @PathVariable("id") Long id){
        return service.updateStore(recipe, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

}
