package com.rededev.domain;

import com.rededev.domain.enums.StatusCandidatura;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidaturas")
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programador_id")
    private Programador programador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    @Enumerated(EnumType.STRING)
    private StatusCandidatura status;

    private LocalDateTime data;

    public Candidatura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public StatusCandidatura getStatus() {
        return status;
    }

    public void setStatus(StatusCandidatura status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
