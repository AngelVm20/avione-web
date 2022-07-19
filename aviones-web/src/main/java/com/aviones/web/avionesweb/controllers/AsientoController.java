package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.AsientoDTO;
import com.aviones.web.avionesweb.dto.NuevoAsientoDTO;
import com.aviones.web.avionesweb.services.AsientoServices;

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
public class AsientoController {
    final AsientoServices service;

    public AsientoController(AsientoServices srv){
        this.service = srv;
    }

    @PostMapping("/{id}/asientos")
    public ResponseEntity<AsientoDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NuevoAsientoDTO asientoDTO){
       
            AsientoDTO asientoDTO = service.create(id,asientoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(asientoDTO);        
    }

    @GetMapping("/{idVuelo}/asientos/{id}")
    public ResponseEntity<AsientoDTO> retrive(@PathVariable("idVuelo") Long idVuelo, @PathVariable("id") Long id){
            AsientoDTO result = service.retrieve(idVuelo, id);
            return ResponseEntity.ok().body(result);
        
    }

    @GetMapping("/{id}/asientos") //el verbo es diferente a create ya que va
    public ResponseEntity<List<AsientoDTO>> list(@PathVariable("id") Long id){        
            List <AsientoDTO> asientos  = service.list(id);
            return ResponseEntity.ok().body(asientos);
        
    }

    @PutMapping("/{idVuelo}/asientos/{id}")
    public ResponseEntity<AsientoDTO> update(@RequestBody AsientoDTO asientoDTO, @PathVariable("idVuelo") Long idVuelo, @PathVariable("id") Long id){       
            AsientoDTO result = service.update(asientoDTO, idVuelo,id);
            return ResponseEntity.ok().body(result);        
    }

    @DeleteMapping("/{idVuelo}/asientos/{id}")
    public ResponseEntity<Void> delete( @PathVariable("idVuelo") Long idVuelo, @PathVariable("id") Long id){       
             service.delete(idVuelo,id);
            return ResponseEntity.noContent().build();
       
    }
    
}
