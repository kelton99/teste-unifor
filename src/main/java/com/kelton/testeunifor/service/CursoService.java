package com.kelton.testeunifor.service;

import com.kelton.testeunifor.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

}
