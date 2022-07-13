package com.example.clinicaDental.service;

import com.example.clinicaDental.model.Odontologo;
import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.model.Turno;
import com.example.clinicaDental.model.dto.TurnoDTO;
import com.example.clinicaDental.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void cargarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        Paciente paciente = mapper.convertValue(turnoDTO.getPacienteDTO(), Paciente.class);
        Odontologo odontologo = mapper.convertValue(turnoDTO.getOdontologoDTO(), Odontologo.class);
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turnoRepository.save(turno);
    }

    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        cargarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO buscar(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()) {
            turnoDTO= mapper.convertValue(turno, TurnoDTO.class);
        }

        return turnoDTO;
    }

    @Override
    public void actualizar(TurnoDTO turnoDTO) {
        cargarTurno(turnoDTO);
    }

    @Override
    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> getTodos() {
        List<Turno> turnos =turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno t:turnos) {
            turnoDTOS.add(mapper.convertValue(t, TurnoDTO.class));
        }

        return turnoDTOS;
    }
}
