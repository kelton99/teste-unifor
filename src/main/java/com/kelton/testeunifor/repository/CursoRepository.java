package com.kelton.testeunifor.repository;

import com.kelton.testeunifor.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
