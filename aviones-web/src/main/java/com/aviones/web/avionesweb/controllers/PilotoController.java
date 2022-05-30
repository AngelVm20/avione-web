package com.aviones.web.avionesweb.controllers;

import java.util.List;

import com.aviones.web.avionesweb.dto.NuevoPilotoDTO;
import com.aviones.web.avionesweb.dto.PilotoDTO;
import com.aviones.web.avionesweb.services.PilotoServices;

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
@RequestMapping("/piloto")
public class PilotoController {
    private final PilotoServices service;

    // post /piloto
    //get /piloto/{id}
   //get /piloto

    @Autowired
    public PilotoController(PilotoServices srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NuevoPilotoDTO pilotoDTO){
        try {
            PilotoDTO result = service.create(pilotoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrive(@PathVariable("id") Long id){
        try {
            PilotoDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<?> list(){
        try {
            List <PilotoDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PilotoDTO pilotoDTO, @PathVariable("id") Long id){
        try {
            PilotoDTO result = service.update(pilotoDTO, id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id){
        try {
             service.delete(id);;
            return ResponseEntity.ok().body("Piloto deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }


}
