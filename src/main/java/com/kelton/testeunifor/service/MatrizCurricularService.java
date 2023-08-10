package com.kelton.testeunifor.service;

import com.kelton.testeunifor.repository.MatrizCurricularRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatrizCurricularService {

    private final MatrizCurricularRepository matrizCurricularRepository;

}
