package com.aviones.web.avionesweb.controllers;

import java.util.List;

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
    public ResponseEntity<?> create(@RequestBody NuevoVueloDTO vueloDTO){
        try {
            VueloDTO result = service.create(vueloDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrive(@PathVariable("id") Long id){
        try {
            VueloDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<?> list(){
        try {
            List <VueloDTO> result  = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody VueloDTO vueloDTO, @PathVariable("id") Long id){
        try {
            VueloDTO result = service.update(vueloDTO, id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id){
        try {
             service.delete(id);;
            return ResponseEntity.ok().body("Vuelo deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
    
}
