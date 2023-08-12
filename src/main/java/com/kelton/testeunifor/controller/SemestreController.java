package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.dto.MatrizCurricularDTO;
import com.kelton.testeunifor.dto.SemestreDTO;
import com.kelton.testeunifor.service.SemestreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semestre")
@AllArgsConstructor
public class SemestreController {

    private final SemestreService semestreService;

    @GetMapping()
    public ResponseEntity<List<SemestreDTO>> findSemestres() {
        return ResponseEntity.status(HttpStatus.OK).body(this.semestreService.findSemestres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemestreDTO> findSemestre(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.semestreService.findSemestreById(id));
    }

    @PostMapping()
    public ResponseEntity<SemestreDTO> createSemestre(@RequestBody SemestreDTO semestreDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.semestreService.saveSemestre(semestreDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemestreDTO> updateSemestre(@PathVariable Long id, @RequestBody SemestreDTO semestreDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.semestreService.updateSemestre(id, semestreDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        this.semestreService.deleteSemestreById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
