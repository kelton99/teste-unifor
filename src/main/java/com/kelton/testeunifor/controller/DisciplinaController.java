package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.service.DisciplinaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplina/")
@AllArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
}
