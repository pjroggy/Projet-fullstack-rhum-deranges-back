package Pjcheckpoint3.rhumDeranges.rhum;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rhums")
@RequiredArgsConstructor
public class RhumController {

    private final RhumService service;

    @GetMapping("/all")
    public List<Rhum> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Rhum getStoreById(@PathVariable("id") Long id) {

        return service.getById(id);
    }

    @PostMapping("/add")
    public Rhum create(@RequestBody Rhum rhum) {
        return service.create(rhum);
    }

    @PutMapping("/update/{id}")
    public Rhum update(@RequestBody Rhum rhum, @PathVariable("id") Long id){
        return service.updateStore(rhum, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

}