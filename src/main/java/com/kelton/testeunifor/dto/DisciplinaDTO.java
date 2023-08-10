package com.kelton.testeunifor.dto;

import com.kelton.testeunifor.model.Disciplina;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DisciplinaDTO {

    private Long id;

    private String nome;

    private Integer credito;

    public static DisciplinaDTO mapToDto(Disciplina disciplina) {
        return DisciplinaDTO.builder()
                .id(disciplina.getId())
                .nome(disciplina.getNome())
                .credito(disciplina.getCredito())
                .build();
    }

    public static Disciplina mapToEntity(DisciplinaDTO disciplinaDTO) {
        return null;
    }
}
