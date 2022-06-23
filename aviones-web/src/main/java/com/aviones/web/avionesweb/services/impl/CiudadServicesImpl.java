package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.aviones.web.avionesweb.dto.CiudadDTO;
import com.aviones.web.avionesweb.dto.NuevoCiudad;
import com.aviones.web.avionesweb.exceptions.ResourceNotFoundException;
import com.aviones.web.avionesweb.models.Ciudad;
import com.aviones.web.avionesweb.repositories.CiudadReposiroy;
import com.aviones.web.avionesweb.services.CiudadServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CiudadServicesImpl implements CiudadServices {
    
    final ModelMapper modelMapper;
    final CiudadReposiroy ciudadRepository;
    
    @Autowired
    public CiudadServicesImpl(@Autowired CiudadReposiroy repository, ModelMapper mapper){
        this.ciudadRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public CiudadDTO create(NuevoCiudad ciudadDTO) {
        Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
        ciudadRepository.save(ciudad);
        return modelMapper.map(ciudad, CiudadDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CiudadDTO retrieve(Long id){
        Ciudad ciudad = ciudadRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));
        return modelMapper.map(ciudad,CiudadDTO.class);
    }

    @Override
    @Transactional
    public CiudadDTO update(CiudadDTO ciudadDTO, Long id) {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ciudad no encontrada"));
        ciudad.setId(id);
        ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
        ciudadRepository.save(ciudad);       

        return modelMapper.map(ciudad, CiudadDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ciudad no encontrada"));        
        ciudadRepository.deleteById(ciudad.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<CiudadDTO> list() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudades.stream().map(ciudad -> modelMapper.map(ciudad, CiudadDTO.class))
            .collect(Collectors.toList());        
    }
}
