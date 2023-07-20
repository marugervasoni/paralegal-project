package com.api.paralegal.service;

import com.api.paralegal.model.Expediente;
import com.api.paralegal.model.dto.ExpedienteDTO;
import com.api.paralegal.repository.IExpedienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExpedienteService implements IExpedienteService {

    @Autowired
    private IExpedienteRepository expedienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarExpediente(ExpedienteDTO expedienteDTO){
        Expediente expediente = mapper.convertValue(expedienteDTO, Expediente.class);
        expedienteRepository.save(expediente);
    }

    @Override
    public void crearExpediente(ExpedienteDTO expedienteDTO) {
        guardarExpediente(expedienteDTO);
    }

    @Override
    public ExpedienteDTO leerExpediente(Long id) {
        Optional<Expediente> expediente = expedienteRepository.findById(id);
        ExpedienteDTO expedienteDTO = null;
        if (expediente.isPresent())
            expedienteDTO = mapper.convertValue(expediente, ExpedienteDTO.class);
        return expedienteDTO;
    }

    @Override
    public void actualizarExpediente(ExpedienteDTO expedienteDTO) {
        guardarExpediente(expedienteDTO);
    }

    @Override
    public void eliminarExpediente(Long id) {
        expedienteRepository.deleteById(id);
    }

    @Override
    public Set<ExpedienteDTO> listarExpedientes() {
        List<Expediente> expedientes = expedienteRepository.findAll();
        Set<ExpedienteDTO> expedientesDTO = new HashSet<>();
        for (Expediente expediente: expedientes) {
            expedientesDTO.add(mapper.convertValue(expediente, ExpedienteDTO.class));
        }
        return expedientesDTO;
    }
}
