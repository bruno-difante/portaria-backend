package br.edu.ufn.portaria.controller;

import br.edu.ufn.portaria.model.Item;
import br.edu.ufn.portaria.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item buscarPorId(@PathVariable String id) {
        return itemRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Item criarItem(@RequestBody Item item) {
        item.setStatus("disponível"); // padrão
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public Item atualizarItem(@PathVariable String id, @RequestBody Item itemAtualizado) {
        return itemRepository.findById(id).map(item -> {
            item.setNome(itemAtualizado.getNome());
            item.setCodigoBarras(itemAtualizado.getCodigoBarras());
            item.setStatus(itemAtualizado.getStatus());
            return itemRepository.save(item);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable String id) {
        itemRepository.deleteById(id);
    }
}