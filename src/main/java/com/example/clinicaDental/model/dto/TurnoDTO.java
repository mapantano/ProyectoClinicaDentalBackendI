package com.example.clinicaDental.model.dto;

import com.example.clinicaDental.model.Odontologo;
import com.example.clinicaDental.model.Paciente;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class TurnoDTO {
    private Integer idTurno;
    private Date fecha;
    private String hora;
    private PacienteDTO pacienteDTO;
    private OdontologoDTO odontologoDTO;

    public TurnoDTO() {
    }

}
