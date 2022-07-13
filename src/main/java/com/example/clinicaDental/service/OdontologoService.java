package com.example.clinicaDental.service;


import com.example.clinicaDental.model.Odontologo;
import com.example.clinicaDental.model.dto.OdontologoDTO;
import com.example.clinicaDental.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public Odontologo cargarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return odontologoRepository.save(odontologo);

    }
    @Override
    public Odontologo guardarOdontologo(OdontologoDTO odontologoDTO) {
       return cargarOdontologo(odontologoDTO);

    }

    @Override
    public OdontologoDTO buscar(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()) {
             odontologoDTO= mapper.convertValue(odontologo, OdontologoDTO.class);
        }

        return odontologoDTO;
    }

    @Override
    public Odontologo actualizar(OdontologoDTO odontologoDTO) {

        return cargarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminar(Integer id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> getTodos() {

        List<Odontologo> odontologos =odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();

        for (Odontologo o:odontologos) {
            odontologoDTOS.add(mapper.convertValue(o, OdontologoDTO.class));
        }

        return odontologoDTOS;
    }


}
