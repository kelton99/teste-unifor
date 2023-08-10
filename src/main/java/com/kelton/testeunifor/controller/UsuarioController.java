package com.kelton.testeunifor.controller;

import com.kelton.testeunifor.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario/")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
}
