package com.example.clinicaDental.controller;


import com.example.clinicaDental.model.Odontologo;
import com.example.clinicaDental.model.dto.OdontologoDTO;
import com.example.clinicaDental.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IOdontologoService odontologoService;



    @PostMapping
    public ResponseEntity<?> guardarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.guardarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> obtenerOdontologo(@PathVariable Integer id){
        ResponseEntity<OdontologoDTO> respuesta;
        OdontologoDTO odontologoDTO = odontologoService.buscar(id);
        if(odontologoDTO == null){
            respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            respuesta = ResponseEntity.ok(odontologoDTO);
        }
        return respuesta;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        ResponseEntity response = null;
        if (odontologoService.buscar(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            odontologoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody OdontologoDTO odontologoDTO) {
        ResponseEntity response = null;
        if (odontologoService.buscar(odontologoDTO.getId()) == null) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            odontologoService.actualizar(odontologoDTO);
            response = ResponseEntity.ok(HttpStatus.OK );

        }
        return response;

    }

    @GetMapping
    public ResponseEntity<Collection<OdontologoDTO>> obtenerLosOdontologos(){
        return ResponseEntity.ok(odontologoService.getTodos());
    }



}
