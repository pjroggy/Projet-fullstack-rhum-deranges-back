package Pjcheckpoint3.rhumDeranges.rhum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RhumRepository extends JpaRepository<Rhum, Long> {
}
