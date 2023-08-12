package com.kelton.testeunifor.service;

import com.kelton.testeunifor.dto.DisciplinaDTO;
import com.kelton.testeunifor.dto.SemestreDTO;
import com.kelton.testeunifor.exception.EntidadeNaoEncontradaException;
import com.kelton.testeunifor.repository.SemestreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public List<SemestreDTO> findSemestres() {
        return this.semestreRepository.findAll()
                .stream()
                .map(SemestreDTO::mapToDto)
                .collect(Collectors.toList());
    }

    public SemestreDTO findSemestreById(Long id) {
        return SemestreDTO.mapToDto(this.semestreRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Semestre com id %d não foi encontrado", id)))
        );
    }

    public SemestreDTO saveSemestre(SemestreDTO semestreDTO) {
        final var semestre = this.semestreRepository.save(SemestreDTO.mapToEntity(semestreDTO));

        return SemestreDTO.mapToDto(semestre);
    }

    public SemestreDTO updateSemestre(Long id, SemestreDTO semestreDTO) {
        final var semestre = this.semestreRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Semestre com id %d não foi encontrado", id))
        );

        semestre.setAno(semestreDTO.getAno());
        semestre.setNumero(semestreDTO.getNumero());
        semestre.setDisciplinas(semestreDTO.getDisciplinas()
                .stream()
                .map(DisciplinaDTO::mapToEntity)
                .collect(Collectors.toList()));

        return SemestreDTO.mapToDto(this.semestreRepository.save(semestre));
    }

    public void deleteSemestreById(Long id) {
        final var semestre = this.semestreRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Semestre com id %d não foi encontrado", id))
        );
        this.semestreRepository.delete(semestre);
    }
}
