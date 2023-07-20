package com.api.paralegal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Expedientes")
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String actores;

    private String demandados;

    private String objeto;

    private Integer numExpte;

    private Integer añoInicio;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_juzgado")
    private Juzgado juzgado;

    private String infoAdicionalExpte;

    @OneToMany(mappedBy = "expediente")
    @JsonIgnore
    private List<Audiencia> audiencias;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "expediente")
    @JsonIgnore
    private List<Recordatorio> recordatorios;
}