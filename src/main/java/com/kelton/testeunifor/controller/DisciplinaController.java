package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.dto.CursoDTO;
import com.kelton.testeunifor.dto.DisciplinaDTO;
import com.kelton.testeunifor.service.DisciplinaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
@AllArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping("/")
    public ResponseEntity<List<DisciplinaDTO>> findDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(this.disciplinaService.findDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> findDisciplina(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.disciplinaService.findDisciplinaById(id));
    }

    @PostMapping("/")
    public ResponseEntity<DisciplinaDTO> createDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.disciplinaService.saveDisciplina(disciplinaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> updateDisciplina(@PathVariable Long id, @RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.disciplinaService.updateDisciplina(id, disciplinaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable Long id) {
        this.disciplinaService.deleteDisciplinaById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
