package com.aviones.web.avionesweb.controllers;

import java.util.List;

import com.aviones.web.avionesweb.dto.CiudadDTO;
import com.aviones.web.avionesweb.dto.NuevoCiudad;
import com.aviones.web.avionesweb.services.CiudadServices;

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
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadServices service;

    // post /ciudad
    //get /ciudad/{id}
    //get /ciudad

    @Autowired
    public CiudadController(CiudadServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NuevoCiudad ciudadDTO){
        try {
            CiudadDTO result = service.create(ciudadDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrive(@PathVariable("id") Long id){
        try {
            CiudadDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<?> list(){
        try {
            List <CiudadDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CiudadDTO ciudadDTO, @PathVariable("id") Long id){
        try {
            CiudadDTO result = service.update(ciudadDTO, id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id){
        try {
             service.delete(id);
            return ResponseEntity.ok().body("Ciudad deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    
}
