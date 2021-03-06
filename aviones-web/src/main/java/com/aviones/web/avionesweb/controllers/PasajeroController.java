package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.NuevoPasajeroDTO;
import com.aviones.web.avionesweb.dto.PasajeroDTO;
import com.aviones.web.avionesweb.services.PasajeroServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vuelos")
public class PasajeroController {
    private final PasajeroServices service;

    
    public PasajeroController(PasajeroServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<PasajeroDTO> create(@Valid @RequestBody NuevoPasajeroDTO pasajeroDTO){
        
            PasajeroDTO result = service.create(pasajeroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasajeroDTO> retrive(@PathVariable("id") Long id){
        
            PasajeroDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<PasajeroDTO>> list(){
       
            List <PasajeroDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasajeroDTO> update(@RequestBody PasajeroDTO pasajeroDTO, @PathVariable("id") Long id){
        
            PasajeroDTO result = service.update(pasajeroDTO, id);
            return ResponseEntity.ok().body(result);
       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable("id") Long id){
        
             service.delete(id);;
            return ResponseEntity.ok().body("Pasajero borrado!");
        
    }


}
