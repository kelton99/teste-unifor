package com.kelton.testeunifor.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "matriz_curricular")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatrizCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "disciplina_matriz",
            joinColumns = @JoinColumn(name = "matriz_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Disciplina> disciplinas;

    @OneToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrizCurricular that = (MatrizCurricular) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
