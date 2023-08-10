package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.service.SemestreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semestre/")
@AllArgsConstructor
public class SemestreController {

    private final SemestreService semestreService;
}
