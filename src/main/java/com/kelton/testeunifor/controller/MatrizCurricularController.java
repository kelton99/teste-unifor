package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.dto.DisciplinaDTO;
import com.kelton.testeunifor.dto.MatrizCurricularDTO;
import com.kelton.testeunifor.service.MatrizCurricularService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriz-curricular")
@AllArgsConstructor
public class MatrizCurricularController {

    private final MatrizCurricularService matrizCurricularService;

    @GetMapping("/")
    public ResponseEntity<List<MatrizCurricularDTO>> findMatrizes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.matrizCurricularService.findMatrizes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatrizCurricularDTO> findMatriz(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.matrizCurricularService.findMatrizById(id));
    }

    @PostMapping("/")
    public ResponseEntity<MatrizCurricularDTO> createMatriz(@RequestBody MatrizCurricularDTO matrizCurricularDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.matrizCurricularService.saveMatrizCurricular(matrizCurricularDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatrizCurricularDTO> updateMatriz(@PathVariable Long id, @RequestBody MatrizCurricularDTO matrizCurricularDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.matrizCurricularService.updateMatriz(id, matrizCurricularDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatriz(@PathVariable Long id) {
        this.matrizCurricularService.deleteMatrizById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
