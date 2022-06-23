package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aviones.web.avionesweb.dto.AsientoDTO;
import com.aviones.web.avionesweb.dto.NuevoAsientoDTO;
import com.aviones.web.avionesweb.exceptions.ResourceNotFoundException;
import com.aviones.web.avionesweb.models.Asiento;
import com.aviones.web.avionesweb.repositories.AsientoRepository;
import com.aviones.web.avionesweb.services.AsientoServices;

@Service
public class AsientoServicesImpl implements AsientoServices{
    
    final ModelMapper modelMapper;
    final AsientoRepository asientoRepository;
    
    @Autowired
    public AsientoServicesImpl(@Autowired AsientoRepository repository, ModelMapper mapper){
        this.asientoRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public AsientoDTO create(NuevoAsientoDTO asientoDTO) {
        Asiento asiento = modelMapper.map(asientoDTO, Asiento.class);
        asientoRepository.save(asiento);
        return modelMapper.map(asiento, AsientoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public AsientoDTO retrieve(Long id) {
        Asiento asiento = asientoRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Asiento no encontrado"));
        return modelMapper.map(asiento, AsientoDTO.class);
        
    }

    @Override
    @Transactional
    public AsientoDTO update(AsientoDTO asientoDTO, Long id) {
        Asiento asiento = asientoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Asiento no encontrado"));
        asiento.setId(id);
        asiento = modelMapper.map(asientoDTO, Asiento.class);
        asientoRepository.save(asiento);       

        return modelMapper.map(asiento, AsientoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Asiento asiento = asientoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Asiento no encontrado"));        
        asientoRepository.deleteById(asiento.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsientoDTO> list() {
        List<Asiento> asientos = asientoRepository.findAll();
        return asientos.stream().map(asiento -> modelMapper.map(asiento, AsientoDTO.class))
            .collect(Collectors.toList());        
    }
}
