package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aviones.web.avionesweb.dto.VueloDTO;
import com.aviones.web.avionesweb.dto.NuevoVueloDTO;
import com.aviones.web.avionesweb.models.Vuelo;
import com.aviones.web.avionesweb.repositories.VueloRepository;
import com.aviones.web.avionesweb.services.VueloServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VueloServicesImpl implements VueloServices{
    
    final ModelMapper modelMapper;
    final VueloRepository vueloRepository;
    
    @Autowired
    public VueloServicesImpl(@Autowired VueloRepository repository, ModelMapper mapper){
        this.vueloRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public VueloDTO create(NuevoVueloDTO vueloDTO) {
        Vuelo vuelo = modelMapper.map(vueloDTO, Vuelo.class);
        vueloRepository.save(vuelo);
        VueloDTO vueloDTOCreated = modelMapper.map(vuelo, VueloDTO.class); 
        return vueloDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public VueloDTO retrieve(Long id) throws Exception {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);
        if(vuelo.isPresent()){
            throw new Exception("Vuelo no encontrado");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(vuelo.get(),VueloDTO.class);
    }

    @Override
    @Transactional
    public VueloDTO update(VueloDTO vueloDTO,Long id) throws Exception {
        Vuelo vuelo = vueloRepository.findById(vueloDTO.getId())
                .orElseThrow(()-> new Exception("Vuelo no encontrado"));
        vuelo.setId(id);
        vuelo = modelMapper.map(vueloDTO, Vuelo.class);
        vueloRepository.save(vuelo);       

        return modelMapper.map(vuelo, VueloDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Vuelo vuelo = vueloRepository.findById(id)
                .orElseThrow(()-> new Exception("Vuelo no encontrado"));        
        vueloRepository.deleteById(vuelo.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<VueloDTO> list() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        return vuelos.stream().map(vuelo -> modelMapper.map(vuelo, VueloDTO.class))
            .collect(Collectors.toList());        
    }
}
