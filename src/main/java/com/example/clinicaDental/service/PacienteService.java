package com.example.clinicaDental.service;


import com.example.clinicaDental.model.Domicilio;
import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.model.dto.PacienteDTO;
import com.example.clinicaDental.repository.IDomicilioRepository;
import com.example.clinicaDental.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;

    public void cargarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Domicilio domicilio = mapper.convertValue(pacienteDTO.getDomicilioDTO(), Domicilio.class);
        pacienteRepository.save(paciente);
        domicilioRepository.save(domicilio);
    }

    @Override
    public Paciente guardarPaciente(PacienteDTO pacienteDTO) {
        cargarPaciente(pacienteDTO);
        return null;
    }

    @Override
    public PacienteDTO buscar(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent()) {
            pacienteDTO= mapper.convertValue(paciente, PacienteDTO.class);
        }

        return pacienteDTO;
    }

    @Override
    public void actualizar(PacienteDTO pacienteDTO) {
        cargarPaciente(pacienteDTO);
    }

    @Override
    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> getTodos() {
        List<Paciente> pacientes =pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();

        for (Paciente P:pacientes) {
            pacienteDTOS.add(mapper.convertValue(P, PacienteDTO.class));
        }

        return pacienteDTOS;
    }
}