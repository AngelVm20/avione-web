package com.aviones.web.avionesweb.controllers;

import java.util.List;

import com.aviones.web.avionesweb.dto.AsientoDTO;
import com.aviones.web.avionesweb.dto.NuevoAsientoDTO;
import com.aviones.web.avionesweb.services.AsientoServices;

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
@RequestMapping("/asiento")
public class AsientoController {
    private final AsientoServices service;

    // post /asiento
    //get /asiento/{id}
    //get /asiento

    @Autowired
    public AsientoController(AsientoServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NuevoAsientoDTO asientoDTO){
        try {
            AsientoDTO result = service.create(asientoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrive(@PathVariable("id") Long id){
        try {
            AsientoDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<?> list(){
        try {
            List <AsientoDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AsientoDTO asientoDTO, @PathVariable("id") Long id){
        try {
            AsientoDTO result = service.update(asientoDTO, id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id){
        try {
             service.delete(id);;
            return ResponseEntity.ok().body("Asiento deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
    
}
