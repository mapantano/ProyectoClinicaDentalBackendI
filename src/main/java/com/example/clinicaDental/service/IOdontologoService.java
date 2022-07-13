package com.example.clinicaDental.service;


import com.example.clinicaDental.model.Odontologo;
import com.example.clinicaDental.model.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    Odontologo guardarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscar(Integer id);
    Odontologo actualizar(OdontologoDTO odontologoDTO);
    void eliminar(Integer id);
    Set<OdontologoDTO> getTodos();
}
