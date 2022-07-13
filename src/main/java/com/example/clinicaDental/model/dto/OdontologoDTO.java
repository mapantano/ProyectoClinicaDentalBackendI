package com.example.clinicaDental.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private int matricula;

    public OdontologoDTO() {
    }
}
