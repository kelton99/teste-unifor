package com.kelton.testeunifor.service;

import com.kelton.testeunifor.dto.DisciplinaDTO;
import com.kelton.testeunifor.exception.EntidadeNaoEncontradaException;
import com.kelton.testeunifor.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaDTO> findDisciplinas() {
        return this.disciplinaRepository.findAll()
                .stream()
                .map(DisciplinaDTO::mapToDto)
                .collect(Collectors.toList());
    }

    public DisciplinaDTO findDisciplinaById(Long id) {
        return DisciplinaDTO.mapToDto(this.disciplinaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Disciplina com id %d não foi encontrado", id)))
        );
    }

    public DisciplinaDTO saveDisciplina(DisciplinaDTO disciplinaDTO) {
        final var disciplina = this.disciplinaRepository.save(DisciplinaDTO.mapToEntity(disciplinaDTO));

        return DisciplinaDTO.mapToDto(disciplina);
    }

    public DisciplinaDTO updateDisciplina(Long id, DisciplinaDTO disciplinaDTO) {
        final var disciplina = this.disciplinaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Disciplina com id %d não foi encontrado", id))
        );

        disciplina.setNome(disciplina.getNome());
        disciplina.setCredito(disciplina.getCredito());

        return DisciplinaDTO.mapToDto(
                this.disciplinaRepository.save(DisciplinaDTO.mapToEntity(disciplinaDTO))
        );
    }

    public void deleteDisciplinaById(Long id) {
        final var disciplina = this.disciplinaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Curso com id %d não foi encontrado", id))
        );

        this.disciplinaRepository.delete(disciplina);
    }
}
