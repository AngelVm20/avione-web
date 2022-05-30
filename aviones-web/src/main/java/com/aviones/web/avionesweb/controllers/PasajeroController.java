package com.aviones.web.avionesweb.controllers;

import java.util.List;

import com.aviones.web.avionesweb.dto.NuevoPasajeroDTO;
import com.aviones.web.avionesweb.dto.PasajeroDTO;
import com.aviones.web.avionesweb.services.PasajeroServices;

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
@RequestMapping("/pasajero")
public class PasajeroController {
    private final PasajeroServices service;

    // post /pasajero
    //get /pasajero/{id}
    //get /pasajero

    @Autowired
    public PasajeroController(PasajeroServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NuevoPasajeroDTO pasajeroDTO){
        try {
            PasajeroDTO result = service.create(pasajeroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrive(@PathVariable("id") Long id){
        try {
            PasajeroDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<?> list(){
        try {
            List <PasajeroDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PasajeroDTO pasajeroDTO, @PathVariable("id") Long id){
        try {
            PasajeroDTO result = service.update(pasajeroDTO, id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id){
        try {
             service.delete(id);;
            return ResponseEntity.ok().body("Pasajero deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }


}
