package Pjcheckpoint3.rhumDeranges.rhum;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RhumService {

    private final RhumRepository repository;

    public List<Rhum> getAll() {
        return repository.findAll();
    }

    public Rhum getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Rhum create(Rhum rhum) {
        return repository.save(rhum);
    }

    public Rhum updateStore(Rhum rhum, Long id) {
        Rhum foundRhum = repository.getById(id);
        foundRhum.setName(rhum.getName());
        foundRhum.setOrigin(rhum.getOrigin());
        foundRhum.setAlcoholDegree(rhum.getAlcoholDegree());

        return repository.save(foundRhum);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}