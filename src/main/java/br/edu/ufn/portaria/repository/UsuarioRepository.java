package br.edu.ufn.portaria.repository;

import br.edu.ufn.portaria.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByCodigoBarras(String codigoBarras);
}