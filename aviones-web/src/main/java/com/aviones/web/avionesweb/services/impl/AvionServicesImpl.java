package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aviones.web.avionesweb.dto.AvionDTO;
import com.aviones.web.avionesweb.dto.NuevoAvionDTO;
import com.aviones.web.avionesweb.models.Avion;
import com.aviones.web.avionesweb.repositories.AvionRepository;
import com.aviones.web.avionesweb.services.AvionServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AvionServicesImpl implements AvionServices {
    
    final ModelMapper modelMapper;
    final AvionRepository avionRepository;
    
    @Autowired
    public AvionServicesImpl(@Autowired AvionRepository repository, ModelMapper mapper){
        this.avionRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public AvionDTO create(NuevoAvionDTO avionDTO) {
        Avion avion = modelMapper.map(avionDTO, Avion.class);
        avionRepository.save(avion);
        AvionDTO avionDTOCreated = modelMapper.map(avion, AvionDTO.class); 
        return avionDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public AvionDTO retrieve(Long id) throws Exception {
        Optional<Avion> avion = avionRepository.findById(id);
        if(avion.isPresent()){
            throw new Exception("Avion no encontrado");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(avion.get(),AvionDTO.class);
    }

    @Override
    @Transactional
    public AvionDTO update(AvionDTO avionDTO, Long id) throws Exception {
        Avion avion = avionRepository.findById(id)
                .orElseThrow(()-> new Exception("Avion no encontrado"));
        avion.setId(id);
        avion = modelMapper.map(avionDTO, Avion.class);
        avionRepository.save(avion);       

        return modelMapper.map(avion, AvionDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Avion avion = avionRepository.findById(id)
                .orElseThrow(()-> new Exception("Avion no encontrado"));        
        avionRepository.deleteById(avion.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<AvionDTO> list() {
        List<Avion> aviones = avionRepository.findAll();
        return aviones.stream().map(avion -> modelMapper.map(avion, AvionDTO.class))
            .collect(Collectors.toList());        
    }
}
