package com.kelton.testeunifor.dto;

import com.kelton.testeunifor.model.Cargo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String senha;

    private Cargo cargo;
    
}
