package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aviones.web.avionesweb.dto.CiudadDTO;
import com.aviones.web.avionesweb.dto.NuevoCiudad;
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
        CiudadDTO ciudadDTOCreated = modelMapper.map(ciudad, CiudadDTO.class); 
        return ciudadDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public CiudadDTO retrieve(Long id) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if(ciudad.isPresent()){
            throw new Exception("Ciudad no encontrada");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(ciudad.get(),CiudadDTO.class);
    }

    @Override
    @Transactional
    public CiudadDTO update(CiudadDTO ciudadDTO, Long id) throws Exception {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(()-> new Exception("Ciudad no encontrada"));
        ciudad.setId(id);
        ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
        ciudadRepository.save(ciudad);       

        return modelMapper.map(ciudad, CiudadDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(()-> new Exception("Ciudad no encontrada"));        
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
