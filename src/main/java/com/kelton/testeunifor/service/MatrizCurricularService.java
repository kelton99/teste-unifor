package com.kelton.testeunifor.service;

import com.kelton.testeunifor.dto.CursoDTO;
import com.kelton.testeunifor.dto.DisciplinaDTO;
import com.kelton.testeunifor.dto.MatrizCurricularDTO;
import com.kelton.testeunifor.exception.EntidadeNaoEncontradaException;
import com.kelton.testeunifor.repository.MatrizCurricularRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MatrizCurricularService {

    private final MatrizCurricularRepository matrizCurricularRepository;

    public List<MatrizCurricularDTO> findMatrizes() {
        return this.matrizCurricularRepository.findAll()
                .stream()
                .map(MatrizCurricularDTO::mapToDto)
                .collect(Collectors.toList());
    }

    public MatrizCurricularDTO findMatrizById(Long id) {
        return MatrizCurricularDTO.mapToDto(this.matrizCurricularRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Matriz Curricular com id %d não foi encontrado", id)))
        );
    }

    public MatrizCurricularDTO saveMatrizCurricular(MatrizCurricularDTO matrizCurricularDTO) {
        final var matrizCurricular = this.matrizCurricularRepository
                .save((MatrizCurricularDTO.mapToEntity(matrizCurricularDTO)));

        return MatrizCurricularDTO.mapToDto(matrizCurricular);
    }

    public MatrizCurricularDTO updateMatriz(Long id, MatrizCurricularDTO matrizCurricularDTO) {
        final var matrizCurricular = this.matrizCurricularRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Matriz Curricular com id %d não foi encontrado", id))
        );

        matrizCurricular.setDisciplinas(matrizCurricularDTO.getDisciplinas()
                .stream()
                .map(DisciplinaDTO::mapToEntity)
                .collect(Collectors.toList())
        );
        matrizCurricular.setCurso(MatrizCurricularDTO.CursoDTO.mapToEntity(matrizCurricularDTO.getCursoDTO()));

        return MatrizCurricularDTO.mapToDto(this.matrizCurricularRepository.save(matrizCurricular));
    }

    public void deleteMatrizById(Long id) {
        final var matrizCurricular = this.matrizCurricularRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Matriz Curricular com id %d não foi encontrado", id))
        );

        this.matrizCurricularRepository.delete(matrizCurricular);
    }
}
