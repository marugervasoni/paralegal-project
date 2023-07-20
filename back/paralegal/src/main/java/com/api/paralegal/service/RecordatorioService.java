package com.api.paralegal.service;

import com.api.paralegal.model.Recordatorio;
import com.api.paralegal.model.dto.RecordatorioDTO;
import com.api.paralegal.repository.IRecordatorioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RecordatorioService implements IRecordatorioService{

    @Autowired
    private IRecordatorioRepository recordatorioRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarRecordatorio(RecordatorioDTO recordatorioDTO){
        Recordatorio recordatorio = mapper.convertValue(recordatorioDTO, Recordatorio.class);
        recordatorioRepository.save(recordatorio);
    }

    @Override
    public void crearRecordatorio(RecordatorioDTO recordatorioDTO) {
        guardarRecordatorio(recordatorioDTO);
    }

    @Override
    public RecordatorioDTO verRecordatorio(Long id) {
        Optional<Recordatorio> recordatorio = recordatorioRepository.findById(id);
        RecordatorioDTO recordatorioDTO = null;
        if (recordatorio.isPresent())
            recordatorioDTO = mapper.convertValue(recordatorio, RecordatorioDTO.class);
        return recordatorioDTO;

    }

    @Override
    public void editarRecordatorio(RecordatorioDTO recordatorioDTO) {
        guardarRecordatorio(recordatorioDTO);
    }

    @Override
    public void eliminarRecordatorio(Long id) {
        recordatorioRepository.deleteById(id);
    }

    @Override
    public Set<RecordatorioDTO> listarRecordatorios() {
        List<Recordatorio> recordatorios = recordatorioRepository.findAll();
        Set<RecordatorioDTO> recordatoriosDTO = new HashSet<>();
        for (Recordatorio recordatorio: recordatorios) {
            recordatoriosDTO.add(mapper.convertValue(recordatorio, RecordatorioDTO.class));
        }
        return recordatoriosDTO;

    }
}
