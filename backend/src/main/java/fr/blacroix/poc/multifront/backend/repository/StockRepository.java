package fr.blacroix.poc.multifront.backend.repository;

import fr.blacroix.poc.multifront.backend.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockEntity, Integer> {
}
