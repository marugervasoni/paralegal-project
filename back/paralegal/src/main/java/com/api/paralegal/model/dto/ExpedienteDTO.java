package com.api.paralegal.model.dto;

import com.api.paralegal.model.Cliente;
import com.api.paralegal.model.Juzgado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpedienteDTO {

    private Long id;
    private String actores;
    private String demandados;
    private String objeto;
    private Integer numExpte;
    private Juzgado juzgado;
    private String infoAdicionalExpte;
    private Integer añoInicio;
    private Cliente cliente;
}
