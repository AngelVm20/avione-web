package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.NuevoVueloDTO;
import com.aviones.web.avionesweb.dto.VueloDTO;
import com.aviones.web.avionesweb.services.VueloServices;

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
@RequestMapping("/aviones")
public class VueloController {
    private final VueloServices service;


    public VueloController(VueloServices srv){
        this.service =srv;
    }

    @PostMapping("/{id}/vuelos")
    public ResponseEntity<VueloDTO> create(@PathVariable("id") Long id,@Valid @RequestBody NuevoVueloDTO vueloDTO){
        
            VueloDTO vueloDTO = service.create(id,vueloDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(vueloDTO);
       
    }

    @GetMapping("/{idAvion}/vuelos/{id}")
    public ResponseEntity<VueloDTO> retrive(@PathVariable("idAvion") Long idAvion,@PathVariable("id") Long id){
        
            VueloDTO result = service.retrieve(idAvion,id);
            return ResponseEntity.ok().body(result);
        
    }

    @GetMapping("/{id}/vuelos") //el verbo es diferente a create ya que va
    public ResponseEntity<List<VueloDTO>> list(@PathVariable("id") Long id){
        
            List <VueloDTO> vuelos  = service.list(id);
            return ResponseEntity.ok().body(vuelos);
        
    }

    @PutMapping("/{idAvion}/vuelos/{id}")
    public ResponseEntity<VueloDTO> update(@RequestBody VueloDTO vueloDTO,@PathVariable("idAvion") Long idAvion, @PathVariable("id") Long id){
        
            VueloDTO result = service.update(vueloDTO, idAvion,id);
            return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{idAvion}/vuelos/{id}")
    public ResponseEntity<String> delete( @PathVariable("idAvion") Long idAvion,@PathVariable("id") Long id){
        
             service.delete(idAvion,id);
            return ResponseEntity.noContent().build();        
    }
    
}
