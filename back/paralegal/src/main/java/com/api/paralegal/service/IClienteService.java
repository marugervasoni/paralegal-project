package com.api.paralegal.service;

import com.api.paralegal.model.dto.ClienteDTO;

import java.util.Set;

public interface IClienteService {

    void crearCliente(ClienteDTO clienteDTO);
    ClienteDTO leerCliente(Long id);
    void editarCliente(ClienteDTO clienteDTO);
    void eliminarCliente(Long id);
    Set<ClienteDTO> listarClientes();
}
