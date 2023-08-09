package com.kelton.testeunifor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "semestre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ano;
    private Byte numero;

    @ManyToMany
    @JoinTable(
            name = "semestre_disciplina",
            joinColumns = @JoinColumn(name = "semestre_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semestre semestre = (Semestre) o;
        return id.equals(semestre.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
