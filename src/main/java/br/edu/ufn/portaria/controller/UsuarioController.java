package br.edu.ufn.portaria.controller;

import br.edu.ufn.portaria.model.Usuario;
import br.edu.ufn.portaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable String id, @RequestBody Usuario atualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(atualizado.getNome());
            usuario.setMatricula(atualizado.getMatricula());
            usuario.setCodigoBarras(atualizado.getCodigoBarras());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }
}