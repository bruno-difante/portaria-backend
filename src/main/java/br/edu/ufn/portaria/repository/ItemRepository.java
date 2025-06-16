package br.edu.ufn.portaria.repository;

import br.edu.ufn.portaria.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByCodigoBarras(String codigoBarras);
}