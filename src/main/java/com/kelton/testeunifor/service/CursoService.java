package com.kelton.testeunifor.service;

import com.kelton.testeunifor.dto.CursoDTO;
import com.kelton.testeunifor.dto.DisciplinaDTO;
import com.kelton.testeunifor.exception.EntidadeNaoEncontradaException;
import com.kelton.testeunifor.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<CursoDTO> findCursos() {
        return this.cursoRepository.findAll()
                .stream()
                .map(CursoDTO::mapToDto)
                .collect(Collectors.toList());
    }

    public CursoDTO findCursoById(Long id) {
        return CursoDTO.mapToDto(this.cursoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Curso com id %d não foi encontrado", id)))
        );
    }

    public CursoDTO saveCurso(CursoDTO cursoDTO) {
        final var curso = this.cursoRepository.save(CursoDTO.mapToEntity(cursoDTO));

        return CursoDTO.mapToDto(curso);
    }

    public CursoDTO updateCurso(Long id, CursoDTO cursoDTO) {
        final var curso = this.cursoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Curso com id %d não foi encontrado", id))
        );

        curso.setNome(cursoDTO.getNome());
        curso.setCredito(cursoDTO.getCredito());
        curso.setDisciplinas(cursoDTO.getDisciplinas()
                .stream()
                .map(DisciplinaDTO::mapToEntity)
                .collect(Collectors.toList()));

        return CursoDTO.mapToDto(this.cursoRepository.save(CursoDTO.mapToEntity(cursoDTO)));
    }

    public void deleteCursoById(Long id) {
        final var curso = this.cursoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Curso com id %d não foi encontrado", id))
        );
        this.cursoRepository.delete(curso);
    }
}
