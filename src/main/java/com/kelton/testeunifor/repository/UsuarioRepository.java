package com.kelton.testeunifor.repository;

import com.kelton.testeunifor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
