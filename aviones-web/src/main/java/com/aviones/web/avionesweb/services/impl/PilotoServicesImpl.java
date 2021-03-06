package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.aviones.web.avionesweb.dto.PilotoDTO;
import com.aviones.web.avionesweb.dto.NuevoPilotoDTO;
import com.aviones.web.avionesweb.exceptions.ResourceNotFoundException;
import com.aviones.web.avionesweb.models.Piloto;
import com.aviones.web.avionesweb.repositories.PilotoRepository;
import com.aviones.web.avionesweb.services.PilotoServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PilotoServicesImpl implements PilotoServices{
    
    final ModelMapper modelMapper;
    final PilotoRepository pilotoRepository;
    
    @Autowired
    public PilotoServicesImpl(@Autowired PilotoRepository repository, ModelMapper mapper){
        this.pilotoRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public PilotoDTO create(NuevoPilotoDTO pilotoDTO) {
        Piloto piloto = modelMapper.map(pilotoDTO, Piloto.class);
        pilotoRepository.save(piloto);
        return modelMapper.map(piloto, PilotoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PilotoDTO retrieve(Long id) {
        Piloto piloto = pilotoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));
        return modelMapper.map(piloto,PilotoDTO.class);
    }

    @Override
    @Transactional
    public PilotoDTO update(PilotoDTO pilotoDTO, Long id){
        Piloto piloto = pilotoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Piloto no encontrado"));
        piloto.setId(id);
        piloto = modelMapper.map(pilotoDTO, Piloto.class);
        pilotoRepository.save(piloto);       

        return modelMapper.map(piloto, PilotoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Piloto piloto = pilotoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Piloto no encontrado"));        
        pilotoRepository.deleteById(piloto.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<PilotoDTO> list() {
        List<Piloto> pilotos = pilotoRepository.findAll();
        return pilotos.stream().map(piloto -> modelMapper.map(piloto, PilotoDTO.class))
            .collect(Collectors.toList());        
    }
}
