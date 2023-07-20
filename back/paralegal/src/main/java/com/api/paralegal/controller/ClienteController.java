package com.api.paralegal.controller;

import com.api.paralegal.model.dto.ClienteDTO;
import com.api.paralegal.service.ClienteService;
import com.api.paralegal.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.Endpoints.CLIENTES)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Guardar nuevo cliente")
    @PostMapping
    public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok(Constants.SuccesResponse.CREATED);
    }

    @Operation(summary = "Buscar cliente por ID")
    @GetMapping(Constants.Endpoints.GET_BY_ID)
    public ClienteDTO buscarCliente(@PathVariable Long id) {
        return clienteService.leerCliente(id);
    }

    @Operation(summary = "Editar cliente")
    @PutMapping(Constants.Endpoints.UPDATE)
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteDTO clienteDTO) {
        ResponseEntity<?> response = null;

        if (clienteDTO.getId() != null && clienteService.leerCliente(clienteDTO.getId()) != null) {
            clienteService.editarCliente(clienteDTO);
            response = ResponseEntity.ok(Constants.SuccesResponse.UPDATED);
        } else
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        return response;
    }

    @Operation(summary = "Eliminar cliente")
    @DeleteMapping(Constants.Endpoints.DELETE)
    public ResponseEntity<?> borrarCliente(@PathVariable Long id) {
        ResponseEntity<?> response = null;

        if (clienteService.leerCliente(id) != null) {
            clienteService.eliminarCliente(id);
            response = ResponseEntity.ok(Constants.SuccesResponse.DELETED);
        } else {
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        }
        return response;
    }

    @Operation(summary = "Listar todos los clientes")
    @GetMapping(Constants.Endpoints.LIST_ALL)
    public ResponseEntity<?> traerClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

}
