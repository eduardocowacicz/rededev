package com.rededev.domain;

import com.rededev.domain.enums.NivelCompetencia;
import jakarta.persistence.*;

@Entity
@Table(name = "competencias")
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private NivelCompetencia nivel;

    @ManyToOne
    @JoinColumn(name = "programador_id")
    private Programador programador;

    public Competencia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelCompetencia getNivel() {
        return nivel;
    }

    public void setNivel(NivelCompetencia nivel) {
        this.nivel = nivel;
    }

    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }
}
