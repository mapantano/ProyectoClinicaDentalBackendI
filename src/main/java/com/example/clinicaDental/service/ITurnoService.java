package com.example.clinicaDental.service;


import com.example.clinicaDental.model.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void guardarTurno(TurnoDTO turnoDTO);
    TurnoDTO buscar(Integer id);
    void actualizar(TurnoDTO turnoDTO);
    void eliminar(Integer id);
    Set<TurnoDTO> getTodos();
}
