package com.kelton.testeunifor.service;

import com.kelton.testeunifor.repository.SemestreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SemestreService {

    private final SemestreRepository semestreRepository;
}
