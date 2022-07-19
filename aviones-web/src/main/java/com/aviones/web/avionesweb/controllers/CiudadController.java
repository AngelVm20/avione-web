package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.CiudadDTO;
import com.aviones.web.avionesweb.dto.NuevoCiudad;
import com.aviones.web.avionesweb.services.CiudadServices;

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
public class CiudadController {

    private final CiudadServices service;

    public CiudadController(CiudadServices srv){
        this.service =srv;
    }

    @PostMapping("/{id}/ciudades")
    public ResponseEntity<CiudadDTO> create(@PathVariable("id") Long id,@Valid @RequestBody NuevoCiudad ciudadDTO){
        
            CiudadDTO ciudadDTO = service.create(id,ciudadDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ciudadDTO);
        
    }

    @GetMapping("/{idVuelo}/ciudades/{id}")
    public ResponseEntity<CiudadDTO> retrive(@PathVariable("idVuelo") Long idVuelo,@PathVariable("id") Long id){
        
            CiudadDTO result = service.retrieve(idVuelo,id);
            return ResponseEntity.ok().body(result);
        
    }

    @GetMapping("/{id}/ciudades") //el verbo es diferente a create ya que va
    public ResponseEntity<List<CiudadDTO>> list(@PathVariable("id") Long id){
        
            List <CiudadDTO> ciudades  = service.list(id);
            return ResponseEntity.ok().body(ciudades);
       
    }

    @PutMapping("/{idVuelo}/ciudades/{id}")
    public ResponseEntity<CiudadDTO> update(@RequestBody CiudadDTO ciudadDTO,@PathVariable("idVuelo") Long idVuelo, @PathVariable("id") Long id){
        
            CiudadDTO result = service.update(ciudadDTO,idVuelo, id);
            return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{idVuelo}/ciudades/{id}")
    public ResponseEntity<String> delete( @PathVariable("idVuelo") Long idVuelo,@PathVariable("id") Long id){
        
             service.delete(idVuelo,id);
            return ResponseEntity.noContent().build();
        
    }

    
}
