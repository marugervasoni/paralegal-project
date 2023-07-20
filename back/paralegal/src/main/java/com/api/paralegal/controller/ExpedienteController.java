package com.api.paralegal.controller;

import com.api.paralegal.model.dto.ExpedienteDTO;
import com.api.paralegal.service.ExpedienteService;
import com.api.paralegal.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.Endpoints.EXPEDIENTES)
public class ExpedienteController {

    @Autowired
    private ExpedienteService expedienteService;

    @Operation(summary = "Crear nuevo expediente")
    @PostMapping
    public ResponseEntity<?> guardarExpediente(@RequestBody ExpedienteDTO expedienteDTO){
        expedienteService.crearExpediente(expedienteDTO);
        return ResponseEntity.ok(Constants.SuccesResponse.CREATED);
    }

    @Operation(summary = "Buscar expediente por ID")
    @GetMapping(Constants.Endpoints.GET_BY_ID)
    public ExpedienteDTO buscarExpediente(@PathVariable Long id) {
        return expedienteService.leerExpediente(id);
    }

    @Operation(summary = "Actualizar expediente")
    @PutMapping(Constants.Endpoints.UPDATE)
    public ResponseEntity<?> modificarExpediente(@RequestBody ExpedienteDTO expedienteDTO) {
        ResponseEntity<?> response = null;

        if (expedienteDTO.getId() != null && expedienteService.leerExpediente(expedienteDTO.getId()) != null) {
            expedienteService.actualizarExpediente(expedienteDTO);
            response = ResponseEntity.ok(Constants.SuccesResponse.UPDATED);
        } else
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        return response;
    }

    @Operation(summary = "Eliminar expediente")
    @DeleteMapping(Constants.Endpoints.DELETE)
    public ResponseEntity<?> borrarExpediente(@PathVariable Long id) {
        ResponseEntity<?> response = null;

        if (expedienteService.leerExpediente(id) != null) {
            expedienteService.eliminarExpediente(id);
            response = ResponseEntity.ok(Constants.SuccesResponse.DELETED);
        } else {
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        }
        return response;
    }

    @Operation(summary = "Listar todos los expedientes")
    @GetMapping(Constants.Endpoints.LIST_ALL)
    public ResponseEntity<?> traerExpedientes() {
        return ResponseEntity.ok(expedienteService.listarExpedientes());
    }

}
