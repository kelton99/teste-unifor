package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.dto.SemestreDTO;
import com.kelton.testeunifor.model.Usuario;
import com.kelton.testeunifor.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> findSemestres() {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findSemestre(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findUsuarioById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> createSemestre(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.saveUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateSemestre(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.updateUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        this.usuarioService.deleteUsuarioById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
