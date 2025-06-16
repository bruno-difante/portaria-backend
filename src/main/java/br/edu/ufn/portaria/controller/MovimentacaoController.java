package br.edu.ufn.portaria.controller;

import br.edu.ufn.portaria.model.Item;
import br.edu.ufn.portaria.model.Movimentacao;
import br.edu.ufn.portaria.repository.ItemRepository;
import br.edu.ufn.portaria.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Movimentacao> listarTodas() {
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public Movimentacao registrarMovimentacao(@RequestBody Movimentacao mov) {
        mov.setDataHora(LocalDateTime.now());

        itemRepository.findById(mov.getItemId()).ifPresent(item -> {
            if (mov.getTipo().equalsIgnoreCase("emprestimo")) {
                item.setStatus("emprestado");
            } else if (mov.getTipo().equalsIgnoreCase("devolucao")) {
                item.setStatus("disponível");
            }
            itemRepository.save(item);
        });

        return movimentacaoRepository.save(mov);
    }

    // Listar movimentações por item
    @GetMapping("/item/{itemId}")
    public List<Movimentacao> listarPorItem(@PathVariable String itemId) {
        return movimentacaoRepository.findByItemId(itemId);
    }

    // Listar movimentações por usuário
    @GetMapping("/usuario/{usuarioId}")
    public List<Movimentacao> listarPorUsuario(@PathVariable String usuarioId) {
        return movimentacaoRepository.findByUsuarioId(usuarioId);
    }

}