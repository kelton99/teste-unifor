package com.kelton.testeunifor.dto;

import com.kelton.testeunifor.model.Curso;
import com.kelton.testeunifor.model.MatrizCurricular;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MatrizCurricularDTO {

    private Long id;

    private List<DisciplinaDTO> disciplinas;

    private CursoDTO cursoDTO;


    public static MatrizCurricularDTO mapToDto(MatrizCurricular matrizCurricular) {
        return MatrizCurricularDTO.builder()
                .id(matrizCurricular.getId())
                .disciplinas(matrizCurricular.getDisciplinas().stream().map(DisciplinaDTO::mapToDto).collect(Collectors.toList()))
                .cursoDTO(new MatrizCurricularDTO.CursoDTO(matrizCurricular.getCurso()))
                .build();
    }

    public static MatrizCurricular mapToEntity(MatrizCurricularDTO matrizCurricularDTO) {
        return MatrizCurricular.builder()
                .id(matrizCurricularDTO.getId())
                .disciplinas(matrizCurricularDTO.getDisciplinas().stream()
                        .map(DisciplinaDTO::mapToEntity)
                        .collect(Collectors.toList()))
                .curso(MatrizCurricularDTO.CursoDTO.mapToEntity(matrizCurricularDTO.getCursoDTO()))
                .build();
    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class CursoDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private Integer credito;

        public CursoDTO(Curso curso) {
            this.id = curso.getId();
            this.nome = curso.getNome();
            this.credito = curso.getCredito();
        }

        public static Curso mapToEntity(CursoDTO cursoDTO) {
            return Curso.builder()
                    .id(cursoDTO.getId())
                    .nome(cursoDTO.getNome())
                    .credito(cursoDTO.getCredito())
                    .build();
        }
    }
}
