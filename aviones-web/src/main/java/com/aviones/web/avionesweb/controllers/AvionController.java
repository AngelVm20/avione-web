package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.AvionDTO;
import com.aviones.web.avionesweb.dto.NuevoAvionDTO;
import com.aviones.web.avionesweb.services.AvionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aviones")
public class AvionController {
    private final AvionServices service;

    // post /aviones
    //get /aviones/{id}
    //get /aviones

    @Autowired
    public AvionController(AvionServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<AvionDTO> create(@Valid @RequestBody NuevoAvionDTO avionDTO){
        
            AvionDTO result = service.create(avionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvionDTO> retrive(@PathVariable("id") Long id){
        
            AvionDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
   
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<AvionDTO>> list(){
        
            List <AvionDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvionDTO> update(@RequestBody AvionDTO avionDTO, @PathVariable("id") Long id){
        
            AvionDTO result = service.update(avionDTO, id);
            return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable("id") Long id){
        
             service.delete(id);;
            return ResponseEntity.ok().body("Avion borrado!");
       
    }
}
