package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.NuevoVueloDTO;
import com.aviones.web.avionesweb.dto.VueloDTO;
import com.aviones.web.avionesweb.services.VueloServices;

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
@RequestMapping("/vuelo")
public class VueloController {
    private final VueloServices service;

    // post /vuelo
    //get /vuelo/{id}
    //get /vuelo

    @Autowired
    public VueloController(VueloServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<VueloDTO> create(@Valid @RequestBody NuevoVueloDTO vueloDTO){
        
            VueloDTO result = service.create(vueloDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> retrive(@PathVariable("id") Long id){
        
            VueloDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<VueloDTO>> list(){
        
            List <VueloDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> update(@RequestBody VueloDTO vueloDTO, @PathVariable("id") Long id){
        
            VueloDTO result = service.update(vueloDTO, id);
            return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable("id") Long id){
        
             service.delete(id);;
            return ResponseEntity.ok().body("Vuelo deleted!");
        
    }
    
}
