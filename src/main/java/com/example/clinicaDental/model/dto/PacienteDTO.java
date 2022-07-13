package com.example.clinicaDental.model.dto;

import com.example.clinicaDental.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private Date fechaIngreso;
    private DomicilioDTO domicilioDTO;

    public PacienteDTO() {
    }

}
