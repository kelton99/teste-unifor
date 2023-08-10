package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.service.MatrizCurricularService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriz-curricular/")
@AllArgsConstructor
public class MatrizCurricularController {

    private final MatrizCurricularService matrizCurricularService;
}
