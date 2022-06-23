package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.aviones.web.avionesweb.dto.PasajeroDTO;
import com.aviones.web.avionesweb.dto.NuevoPasajeroDTO;
import com.aviones.web.avionesweb.exceptions.ResourceNotFoundException;
import com.aviones.web.avionesweb.models.Pasajero;
import com.aviones.web.avionesweb.repositories.PasajeroRepository;
import com.aviones.web.avionesweb.services.PasajeroServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PasajeroServicesImpl implements PasajeroServices {
    
    final ModelMapper modelMapper;
    final PasajeroRepository pasajeroRepository;
    
    @Autowired
    public PasajeroServicesImpl(@Autowired PasajeroRepository repository, ModelMapper mapper){
        this.pasajeroRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public PasajeroDTO create(NuevoPasajeroDTO pasajeroDTO) {
        Pasajero pasajero = modelMapper.map(pasajeroDTO, Pasajero.class);
        pasajeroRepository.save(pasajero);
        return modelMapper.map(pasajero, PasajeroDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PasajeroDTO retrieve(Long id){
        Pasajero pasajero = pasajeroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Pasajero no encontrado"));
        return modelMapper.map(pasajero,PasajeroDTO.class);
    }

    @Override
    @Transactional
    public PasajeroDTO update(PasajeroDTO pasajeroDTO, Long id){
        Pasajero pasajero = pasajeroRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pasajero no encontrado"));
        pasajero.setId(id);
        pasajero = modelMapper.map(pasajeroDTO, Pasajero.class);
        pasajeroRepository.save(pasajero);       

        return modelMapper.map(pasajero, PasajeroDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id){
        Pasajero pasajero = pasajeroRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pasajero no encontrado"));        
        pasajeroRepository.deleteById(pasajero.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<PasajeroDTO> list() {
        List<Pasajero> pasajeros = pasajeroRepository.findAll();
        return pasajeros.stream().map(pasajero -> modelMapper.map(pasajero, PasajeroDTO.class))
            .collect(Collectors.toList());        
    }
}
