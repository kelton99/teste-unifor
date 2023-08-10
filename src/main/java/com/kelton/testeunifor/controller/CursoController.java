package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso/")
@AllArgsConstructor
public class CursoController {

    private final CursoService cursoService;

}
