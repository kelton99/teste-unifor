package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.dto.CursoDTO;
import com.kelton.testeunifor.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/")
    public ResponseEntity<List<CursoDTO>> findCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.findCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> findCurso(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.findCursoById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cursoService.saveCurso(cursoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.updateCurso(id, cursoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        this.cursoService.deleteCursoById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
