package com.api.paralegal.controller;

import com.api.paralegal.model.dto.JuzgadoDTO;
import com.api.paralegal.service.JuzgadoService;
import com.api.paralegal.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.Endpoints.JUZGADOS)
public class JuzgadoController {

    @Autowired
    private JuzgadoService juzgadoService;

    @Operation(summary = "Guardar nuevo juzgado")
    @PostMapping
    public ResponseEntity<?> guardarJuzgado(@RequestBody JuzgadoDTO juzgadoDTO){
        juzgadoService.crearJuzgado(juzgadoDTO);
        return ResponseEntity.ok(Constants.SuccesResponse.CREATED);
    }

    @Operation(summary = "Buscar juzgado por ID")
    @GetMapping(Constants.Endpoints.GET_BY_ID)
    public JuzgadoDTO buscarJuzgado(@PathVariable Long id) {
        return juzgadoService.verJuzgado(id);
    }

    @Operation(summary = "Editar juzgado")
    @PutMapping(Constants.Endpoints.UPDATE)
    public ResponseEntity<?> modificarJuzgado(@RequestBody JuzgadoDTO juzgadoDTO) {
        ResponseEntity<?> response = null;

        if (juzgadoDTO.getId() != null && juzgadoService.verJuzgado(juzgadoDTO.getId()) != null) {
            juzgadoService.editarJuzgado(juzgadoDTO);
            response = ResponseEntity.ok(Constants.SuccesResponse.UPDATED);
        } else
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        return response;
    }

    @Operation(summary = "Eliminar juzgado")
    @DeleteMapping(Constants.Endpoints.DELETE)
    public ResponseEntity<?> borrarJuzgado(@PathVariable Long id) {
        ResponseEntity<?> response = null;

        if (juzgadoService.verJuzgado(id) != null) {
            juzgadoService.eliminarJuzgado(id);
            response = ResponseEntity.ok(Constants.SuccesResponse.DELETED);
        } else {
            response = ResponseEntity.ok(Constants.ErrorResponse.ELEMENT_NOT_FOUND);
        }
        return response;
    }

    @Operation(summary = "Listar todos los juzgados")
    @GetMapping(Constants.Endpoints.LIST_ALL)
    public ResponseEntity<?> traerJuzgados() {
        return ResponseEntity.ok(juzgadoService.listarJuzgados());
    }
}
