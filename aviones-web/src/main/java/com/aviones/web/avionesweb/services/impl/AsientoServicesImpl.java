package com.aviones.web.avionesweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aviones.web.avionesweb.dto.AsientoDTO;
import com.aviones.web.avionesweb.dto.NuevoAsientoDTO;
import com.aviones.web.avionesweb.exceptions.NoContentException;
import com.aviones.web.avionesweb.exceptions.ResourceNotFoundException;
import com.aviones.web.avionesweb.models.Asiento;
import com.aviones.web.avionesweb.models.Vuelo;
import com.aviones.web.avionesweb.repositories.AsientoRepository;
import com.aviones.web.avionesweb.repositories.VueloRepository;
import com.aviones.web.avionesweb.services.AsientoServices;

@Service
public class AsientoServicesImpl implements AsientoServices{
    
    final ModelMapper modelMapper;
    final AsientoRepository asientoRepository;
    final VueloRepository vueloRepository;
    
    public AsientoServicesImpl(AsientoRepository r, VueloRepository er, ModelMapper m){
        this.modelMapper = m;
        this.asientoRepository=r;
        this.vueloRepository=er;
    }

    @Override
    @Transactional
    public AsientoDTO create(Long idVuelo,NuevoAsientoDTO asientoDTO) {
        Vuelo vuelo = vueloRepository.findById(idVuelo).orElseThrow(()
        -> new ResourceNotFoundException("Vuelo no encontrado"));
        Asiento asiento=modelMapper.map(asientoDTO,Asiento.class);
        asiento.setVuelo(vuelo);
        asientoRepository.save(asiento);
        return modelMapper.map(asiento, AsientoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public AsientoDTO retrieve(Long idVuelo,Long id) {
        Vuelo vuelo = vueloRepository.findById(idVuelo)
        .orElseThrow(()->new ResourceNotFoundException("Vuelo no encontrado"));
        
        Asiento asiento = asientoRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Asiento no encontrado"));
        asiento.setVuelo(vuelo);
        return modelMapper.map(asiento, AsientoDTO.class);
        
    }

    @Override
    @Transactional
    public AsientoDTO update(AsientoDTO asientoDTO,Long idVuelo, Long id) {
        Vuelo vuelo = vueloRepository.findById(Vuelo)
        .orElseThrow(()-> new ResourceNotFoundException("vuelo no encontrado"));

        Asiento asiento = asientoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Asiento no encontrado"));
        asiento.setVuelo(vuelo);
        asiento = modelMapper.map(asientoDTO, Asiento.class);
        asientoRepository.save(asiento);       
        return modelMapper.map(asiento, AsientoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long idVuelo,Long id) {
        Vuelo vuelo = vueloRepository.findById(idVuelo)
        .orElseThrow(()->ResourceNotFoundException("Vuelo no encontrado"));

        Asiento asiento = asientoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Asiento no encontrado"));        
        asiento.setVuelo(vuelo);
        asientoRepository.deleteById(asiento.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsientoDTO> list(Long idVuelo) {
        Vuelo vuelo = vueloRepository.findById(vuelo)
        .orElseThrow(()->new ResourceNotFoundException("vuelo no encontrado"));
        List<Asiento> asientos = asientoRepository.findAll(vuelo);
        if(asientos.isEmpty()) throw new NoContentException("asieno esta vacio");
        return asientos.stream().map(asiento -> modelMapper.map(asiento, AsientoDTO.class))
            .collect(Collectors.toList());        
    }
}
