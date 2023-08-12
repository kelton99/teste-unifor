package com.kelton.testeunifor.dto;

import com.kelton.testeunifor.model.Semestre;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SemestreDTO {

    private Long id;

    private Integer ano;

    private Byte numero;

    private List<DisciplinaDTO> disciplinas;

    public static SemestreDTO mapToDto(Semestre semestre) {
        return SemestreDTO.builder()
                .id(semestre.getId())
                .ano(semestre.getAno())
                .numero(semestre.getNumero())
                .disciplinas(semestre.getDisciplinas().stream().map(DisciplinaDTO::mapToDto).collect(Collectors.toList()))
                .build();
    }

    public static Semestre mapToEntity(SemestreDTO semestreDTO) {
        return Semestre.builder()
                .id(semestreDTO.getId())
                .ano(semestreDTO.getAno())
                .numero(semestreDTO.getNumero())
                .disciplinas(semestreDTO.getDisciplinas()
                        .stream()
                        .map(DisciplinaDTO::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
