package com.api.paralegal.service;

import com.api.paralegal.model.Audiencia;
import com.api.paralegal.model.dto.AudienciaDTO;
import com.api.paralegal.repository.IAudienciaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AudienciaService implements IAudienciaService{

    @Autowired
    private IAudienciaRepository audienciaRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarAudiencia(AudienciaDTO audienciaDTO){
        Audiencia audiencia = mapper.convertValue(audienciaDTO, Audiencia.class);
        audienciaRepository.save(audiencia);
    }

    @Override
    public void agendarAudiencia(AudienciaDTO audienciaDTO) {
        guardarAudiencia(audienciaDTO);
    }

    @Override
    public AudienciaDTO leerAudiencia(Long id) {
        Optional<Audiencia> audiencia = audienciaRepository.findById(id);
        AudienciaDTO audienciaDTO = null;
        if (audiencia.isPresent())
            audienciaDTO = mapper.convertValue(audiencia, AudienciaDTO.class);
        return audienciaDTO;
    }

    @Override
    public void editarAudiencia(AudienciaDTO audienciaDTO) {
        guardarAudiencia(audienciaDTO);
    }

    @Override
    public void eliminarAudiencia(Long id) {
        audienciaRepository.deleteById(id);
    }

    @Override
    public Set<AudienciaDTO> listarAudiencias() {
        List<Audiencia> audiencias = audienciaRepository.findAll();
        Set<AudienciaDTO> audienciasDTO = new HashSet<>();
        for (Audiencia audiencia: audiencias) {
            audienciasDTO.add(mapper.convertValue(audiencia, AudienciaDTO.class));
        }
        return audienciasDTO;
    }
}
