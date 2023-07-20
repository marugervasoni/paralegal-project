package com.api.paralegal.service;

import com.api.paralegal.model.dto.RecordatorioDTO;

import java.util.Set;

public interface IRecordatorioService {

    void crearRecordatorio(RecordatorioDTO recordatorioDTO);
    RecordatorioDTO verRecordatorio(Long id);
    void editarRecordatorio(RecordatorioDTO recordatorioDTO);
    void eliminarRecordatorio(Long id);
    Set<RecordatorioDTO> listarRecordatorios();
}
