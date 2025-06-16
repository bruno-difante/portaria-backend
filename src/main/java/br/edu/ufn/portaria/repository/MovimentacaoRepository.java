package br.edu.ufn.portaria.repository;

import br.edu.ufn.portaria.model.Movimentacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovimentacaoRepository extends MongoRepository<Movimentacao, String> {
    List<Movimentacao> findByItemId(String itemId);
    List<Movimentacao> findByUsuarioId(String usuarioId);
}