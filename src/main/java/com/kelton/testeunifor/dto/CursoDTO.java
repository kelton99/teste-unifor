package com.kelton.testeunifor.dto;


import com.kelton.testeunifor.model.Curso;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CursoDTO {

    private Long id;

    private String nome;

    private Integer credito;

    private List<DisciplinaDTO> disciplinas;

    public static CursoDTO mapToDto(Curso curso) {
        return CursoDTO.builder()
                .id(curso.getId())
                .nome(curso.getNome())
                .credito(curso.getCredito())
                .disciplinas(curso.getDisciplinas().stream().map(DisciplinaDTO::mapToDto).collect(Collectors.toList()))
                .build();
    }

    public static Curso mapToEntity(CursoDTO cursoDTO) {
        return Curso.builder()
                .id(cursoDTO.getId())
                .nome(cursoDTO.getNome())
                .credito(cursoDTO.getCredito())
                .disciplinas(cursoDTO.getDisciplinas().stream().map(DisciplinaDTO::mapToEntity).collect(Collectors.toList()))
                .build();
    }
}
