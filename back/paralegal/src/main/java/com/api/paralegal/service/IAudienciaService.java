package com.api.paralegal.service;

import com.api.paralegal.model.dto.AudienciaDTO;

import java.util.Set;

public interface IAudienciaService {

    void agendarAudiencia(AudienciaDTO audienciaDTO);
    AudienciaDTO leerAudiencia(Long id);
    void editarAudiencia(AudienciaDTO audienciaDTO);
    void eliminarAudiencia(Long id);
    Set<AudienciaDTO> listarAudiencias();

}
