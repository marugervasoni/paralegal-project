package com.api.paralegal.service;

import com.api.paralegal.model.dto.JuzgadoDTO;

import java.util.List;
import java.util.Set;

public interface IJuzgadoService {

    void crearJuzgado(JuzgadoDTO juzgadoDTO);
    JuzgadoDTO verJuzgado(Long id);
    void editarJuzgado(JuzgadoDTO juzgadoDTO);
    void eliminarJuzgado(Long id);
    Set<JuzgadoDTO> listarJuzgados();
}
