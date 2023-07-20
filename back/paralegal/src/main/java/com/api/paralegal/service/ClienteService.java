package com.api.paralegal.service;

import com.api.paralegal.model.Cliente;
import com.api.paralegal.model.dto.ClienteDTO;
import com.api.paralegal.repository.IClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarCliente(ClienteDTO clienteDTO){
        Cliente cliente = mapper.convertValue(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
    }

    @Override
    public void crearCliente(ClienteDTO clienteDTO) {
        guardarCliente(clienteDTO);
    }

    @Override
    public ClienteDTO leerCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        ClienteDTO clienteDTO = null;
        if (cliente.isPresent())
            clienteDTO = mapper.convertValue(cliente, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public void editarCliente(ClienteDTO clienteDTO) {
        guardarCliente(clienteDTO);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Set<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        Set<ClienteDTO> clientesDTO = new HashSet<>();
        for (Cliente cliente: clientes) {
            clientesDTO.add(mapper.convertValue(cliente, ClienteDTO.class));
        }
        return clientesDTO;
    }
}
