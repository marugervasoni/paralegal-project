package com.api.paralegal.service;

import com.api.paralegal.model.Juzgado;
import com.api.paralegal.model.dto.JuzgadoDTO;
import com.api.paralegal.repository.IJuzgadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JuzgadoService implements IJuzgadoService{

    @Autowired
    private IJuzgadoRepository juzgadoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarJuzgado(JuzgadoDTO juzgadoDTO){
        Juzgado juzgado = mapper.convertValue(juzgadoDTO, Juzgado.class);
        juzgadoRepository.save(juzgado);
    }

    @Override
    public void crearJuzgado(JuzgadoDTO juzgadoDTO) {
        guardarJuzgado(juzgadoDTO);
    }

    @Override
    public JuzgadoDTO verJuzgado(Long id) {
        Optional<Juzgado> juzgado = juzgadoRepository.findById(id);
        JuzgadoDTO juzgadoDTO = null;
        if (juzgado.isPresent())
            juzgadoDTO = mapper.convertValue(juzgado, JuzgadoDTO.class);
        return juzgadoDTO;
    }

    @Override
    public void editarJuzgado(JuzgadoDTO juzgadoDTO) {
        guardarJuzgado(juzgadoDTO);
    }

    @Override
    public void eliminarJuzgado(Long id) {
        juzgadoRepository.deleteById(id);
    }

    @Override
    public Set<JuzgadoDTO> listarJuzgados() {
        List<Juzgado> juzgados = juzgadoRepository.findAll();
        Set<JuzgadoDTO> juzgadosDTO = new HashSet<>();
        for (Juzgado juzgado: juzgados) {
            juzgadosDTO.add(mapper.convertValue(juzgado, JuzgadoDTO.class));
        }
        return juzgadosDTO;

    }
}
