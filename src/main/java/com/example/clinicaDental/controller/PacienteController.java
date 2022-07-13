package com.example.clinicaDental.controller;

import com.example.clinicaDental.model.dto.PacienteDTO;
import com.example.clinicaDental.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;



    @PostMapping
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> obtenerPaciente(@PathVariable Integer id){
        ResponseEntity<PacienteDTO> respuesta;
        PacienteDTO pacienteDTO = pacienteService.buscar(id);
        if(pacienteDTO == null){
            respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            respuesta = ResponseEntity.ok(pacienteDTO);
        }
        return respuesta;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        ResponseEntity response = null;
        if (pacienteService.buscar(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            pacienteService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity response = null;
        if (pacienteService.buscar(pacienteDTO.getId()) == null) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            pacienteService.actualizar(pacienteDTO);
            response = ResponseEntity.ok(HttpStatus.OK );

        }
        return response;

    }

    @GetMapping
    public ResponseEntity<Collection<PacienteDTO>> obtenerLosPacientes(){
        return ResponseEntity.ok(pacienteService.getTodos());
    }
}



