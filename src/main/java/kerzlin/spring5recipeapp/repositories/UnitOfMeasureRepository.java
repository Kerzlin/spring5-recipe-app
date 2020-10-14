package kerzlin.spring5recipeapp.repositories;

import kerzlin.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
 Optional<UnitOfMeasure> findByDescription(String description);
}
