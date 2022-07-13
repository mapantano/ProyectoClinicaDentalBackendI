package com.example.clinicaDental.controller;

import com.example.clinicaDental.model.dto.OdontologoDTO;
import com.example.clinicaDental.model.dto.PacienteDTO;
import com.example.clinicaDental.model.dto.TurnoDTO;
import com.example.clinicaDental.service.OdontologoService;
import com.example.clinicaDental.service.PacienteService;
import com.example.clinicaDental.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDTO turnoDTO){
        ResponseEntity<?> respuesta;
        PacienteDTO pacienteDTO= pacienteService.buscar(turnoDTO.getPacienteDTO().getId());
        OdontologoDTO odontologoDTO= odontologoService.buscar(turnoDTO.getOdontologoDTO().getId());
        if (pacienteDTO!=null&&odontologoDTO!=null){
            turnoService.guardarTurno(turnoDTO);
            respuesta=ResponseEntity.ok(HttpStatus.OK);
        }
        else{
            respuesta= ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> obtenerTurno(@PathVariable Integer id){
        ResponseEntity<TurnoDTO> respuesta;
        TurnoDTO turnoDTO = turnoService.buscar(id);
        if(turnoDTO  == null){
            respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            respuesta = ResponseEntity.ok(turnoDTO);
        }
        return respuesta;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        ResponseEntity<?> response;
        if (turnoService.buscar(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            turnoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turnoDTO) {
        ResponseEntity<TurnoDTO> response = null;
        if (turnoService.buscar(turnoDTO.getIdTurno()) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            turnoService.actualizar(turnoDTO);
            response = new ResponseEntity(HttpStatus.OK);

        }
        return response;

    }


    @GetMapping
    public ResponseEntity<Collection<TurnoDTO>> listarTurnos(){
        return ResponseEntity.ok(turnoService.getTodos());
    }

}
