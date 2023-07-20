package com.api.paralegal.controller;

import com.api.paralegal.model.dto.RecordatorioDTO;
import com.api.paralegal.service.RecordatorioService;
import com.api.paralegal.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.Endpoints.RECORDATORIOS)
public class RecordatorioController {

    @Autowired
    private RecordatorioService recordatorioService;

    @Operation(summary = "Crear nuevo recordatorio")
    @PostMapping
    public ResponseEntity<?> generarRecordatorio(@RequestBody RecordatorioDTO recordatorioDTO){
        recordatorioService.crearRecordatorio(recordatorioDTO);
        return ResponseEntity.ok(Constants.SuccesResponse.CREATED);
    }

    @Operation(summary = "Buscar recordatorio por ID")
    @GetMapping(Constants.Endpoints.GET_BY_ID)
    public RecordatorioDTO buscarRecordatorio(@PathVariable Long id) {
        return recordatorioService.verRecordatorio(id);
    }

    @Operation(summary = "Editar recordatorio")
    @PutMapping(Constants.Endpoints.UPDATE)
    public ResponseEntity<?> modificarRecordatorio(@RequestBody RecordatorioDTO recordatorioDTO) {
        ResponseEntity<?> response = null;

        if (recordatorioDTO.getId() != null && recordatorioService.verRecordatorio(recordatorioDTO.getId()) != null) {
            recordatorioService.editarRecordatorio(recordatorioDTO);
            response = ResponseEntity.ok(Constants.SuccesResponse.UPDATED);
        } else
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        return response;
    }

    @Operation(summary = "Eliminar recordatorio")
    @DeleteMapping(Constants.Endpoints.DELETE)
    public ResponseEntity<?> borrarRecordatorio(@PathVariable Long id) {
        ResponseEntity<?> response = null;

        if (recordatorioService.verRecordatorio(id) != null) {
            recordatorioService.eliminarRecordatorio(id);
            response = ResponseEntity.ok(Constants.SuccesResponse.DELETED);
        } else {
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        }
        return response;
    }

    @Operation(summary = "Listar todos los recordatorios")
    @GetMapping(Constants.Endpoints.LIST_ALL)
    public ResponseEntity<?> traerRecordatorios() {
        return ResponseEntity.ok(recordatorioService.listarRecordatorios());
    }

}
