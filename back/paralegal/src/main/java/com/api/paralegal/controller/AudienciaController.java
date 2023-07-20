package com.api.paralegal.controller;

import com.api.paralegal.model.dto.AudienciaDTO;
import com.api.paralegal.service.AudienciaService;
import com.api.paralegal.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.Endpoints.AUDIENCIAS)
public class AudienciaController {

    @Autowired
    private AudienciaService audienciaService;


    @Operation(summary = "Agendar nueva audiencia")
    @PostMapping
    public ResponseEntity<?> crearAudiencia(@RequestBody AudienciaDTO audienciaDTO){
        audienciaService.agendarAudiencia(audienciaDTO);
        return ResponseEntity.ok(Constants.SuccesResponse.CREATED);
    }

    @Operation(summary = "Buscar audiencia por ID")
    @GetMapping(Constants.Endpoints.GET_BY_ID)
    public AudienciaDTO buscarAudiencia(@PathVariable Long id) {
        return audienciaService.leerAudiencia(id);
    }

    @Operation(summary = "Editar audiencia")
    @PutMapping(Constants.Endpoints.UPDATE)
    public ResponseEntity<?> modificarAudiencia(@RequestBody AudienciaDTO audienciaDTO) {
        ResponseEntity<?> response = null;

        if (audienciaDTO.getId() != null && audienciaService.leerAudiencia(audienciaDTO.getId()) != null) {
            audienciaService.editarAudiencia(audienciaDTO);
            response = ResponseEntity.ok(Constants.SuccesResponse.UPDATED);
        } else
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        return response;
    }

    @Operation(summary = "Eliminar audiencia")
    @DeleteMapping(Constants.Endpoints.DELETE)
    public ResponseEntity<?> borrarAudiencia(@PathVariable Long id) {
        ResponseEntity<?> response = null;

        if (audienciaService.leerAudiencia(id) != null) {
            audienciaService.eliminarAudiencia(id);
            response = ResponseEntity.ok(Constants.SuccesResponse.DELETED);
        } else {
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        }
        return response;
    }

    @Operation(summary = "Listar todas las audiencias")
    @GetMapping(Constants.Endpoints.LIST_ALL)
    public ResponseEntity<?> traerAudiencias() {
        return ResponseEntity.ok(audienciaService.listarAudiencias());
    }
}
