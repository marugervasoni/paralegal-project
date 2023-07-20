package com.api.paralegal.service;

import com.api.paralegal.model.dto.ExpedienteDTO;

import java.util.Set;

public interface IExpedienteService {

    void crearExpediente(ExpedienteDTO expedienteDTO);
    ExpedienteDTO leerExpediente(Long id);
    void actualizarExpediente(ExpedienteDTO expedienteDTO);
    void eliminarExpediente(Long id);
    Set<ExpedienteDTO> listarExpedientes();
}
