package com.kelton.testeunifor.service;

import com.kelton.testeunifor.exception.EntidadeNaoEncontradaException;
import com.kelton.testeunifor.model.Usuario;
import com.kelton.testeunifor.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> findUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return this.usuarioRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Usuario com id %d não foi encontrado", id))
        );
    }

    public Usuario saveUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
        final var usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Usuario com id %d não foi encontrado", id))
        );

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setCargo(usuarioAtualizado.getCargo());

        return usuario;
    }

    public void deleteUsuarioById(Long id) {
        final var usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Usuario com id %d não foi encontrado", id))
        );

        this.usuarioRepository.delete(usuario);
    }
}
