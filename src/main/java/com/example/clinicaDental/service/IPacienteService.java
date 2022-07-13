package com.example.clinicaDental.service;


import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.model.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    Paciente guardarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscar(Integer id);
    void actualizar(PacienteDTO pacienteDTO);
    void eliminar(Integer id);
    Set<PacienteDTO> getTodos();
}
